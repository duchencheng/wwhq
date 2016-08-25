package whq.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.jdbc.StandardSocketFactory;

import whq.model.FileInfo;
import whq.service.imp.IFileInfoService;

@Controller
@RequestMapping("/Down")
public class DownloadFileController {

	private IFileInfoService fileInfoService;

	public IFileInfoService getFileInfoService() {
		return fileInfoService;
	}

	@Resource
	public void setFileInfoService(IFileInfoService fileInfoService) {
		this.fileInfoService = fileInfoService;
	}

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String listUpload(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("8");
		String uploadFilePath = req.getSession().getServletContext().getRealPath("/resourse/template");

		Map<String, String> fileNameMap = new HashMap<String, String>();
		// �ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
		listfile(new File(uploadFilePath), fileNameMap);
		for (String key : fileNameMap.keySet()) {
			System.out.println(key);
		}
		// ��Map���Ϸ��͵�listfile.jspҳ�������ʾ
		req.setAttribute("fileNameMap", fileNameMap);
		// req.getRequestDispatcher("/listfile.jsp").forward(req, resp);
		return "download";
	}

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public String listUpload() {
		System.out.println("9");
		return "download";
	}

	public void listfile(File file, Map<String, String> map) {
		if (!file.isFile()) {
			File[] files = file.listFiles();
			for (File f : files) {
				listfile(f, map);
			}
		} else {
			String realPath = file.getName();
			if (map.containsKey(file.getName())) {
				System.out.println("�ļ������ظ�");
			} else {
				map.put(file.getName(), realPath);
			}
		}

	}

	@RequestMapping(value = "/shenhe", method = RequestMethod.GET)
	public String shenhe(HttpServletRequest req) {
		System.out.println("���GET");
		String uploadFilePath = req.getSession().getServletContext().getRealPath("/resourse/template");

		Map<String, String> fileNameMap = new HashMap<String, String>();
		listfile(new File(uploadFilePath), fileNameMap);
		for (String key : fileNameMap.keySet()) {
			System.out.println(key);
		}
		req.setAttribute("fileNameMap", fileNameMap);

		return "shenhe";
	}

	/**
	 * �ļ�����
	 * 
	 * @param req
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadfiles", method = RequestMethod.GET)
	public String uploadfiles(HttpServletRequest req, String filename) throws IOException {

		System.out.println("�ϴ�" + filename);
		String uploadFilePath = req.getSession().getServletContext().getRealPath("/resourse/template");
		System.out.println(uploadFilePath);
		File file = new File(uploadFilePath + "\\" + filename);
		FileInfo f = fileInfoService.FindFileByName(filename);
		System.out.println(f.getFile_id() + "  " + f.getFilepath());
		String real = req.getSession().getServletContext().getRealPath("/resourse/real");// ���ͨ�����·��
		String dir = real + "\\" + f.getTitle() + "\\" + f.getType();
		System.out.println(dir);
		File file2 = new File(dir + "/" + filename);
		FileUtils.copyFileToDirectory(file, file2);
		Timestamp t = new Timestamp(new Date().getTime());

		System.out.println(t.toString());
		fileInfoService.UpDate(f.getFile_id(), dir, (byte) 1, t);
		if (file.delete()) {
			System.out.println("�h���ɹ�");
		}
		return "shenhe";

	}

	@RequestMapping(value = "/deletfiles", method = RequestMethod.GET)
	public String deletfiles(HttpServletRequest req, String filename) throws IOException {

		System.out.println("�h��" + filename);
		String uploadFilePath = req.getSession().getServletContext().getRealPath("/resourse/template");
		System.out.println(uploadFilePath);
		File file = new File(uploadFilePath + "\\" + filename);
		if (file.delete()) {
			System.out.println("�h���ɹ�");
		}
		FileInfo f = fileInfoService.FindFileByName(filename);
		System.out.println(f.getFile_id() + "  " + f.getFilepath());
		fileInfoService.DeletByName(f);
		return "shenhe";

	}

	@RequestMapping(value = "/downloadfiles", method = RequestMethod.GET)
	public String downloadfiles(HttpServletRequest req, HttpServletResponse resp, String filename) {

		System.out.println("���GET123");
		String uploadFilePath = req.getSession().getServletContext().getRealPath("/resourse/real");

		Map<String, String> fileNameMap = new HashMap<String, String>();
		listfile(new File(uploadFilePath), fileNameMap);
		for (String key : fileNameMap.keySet()) {
			System.out.println(key);
		}
		req.setAttribute("fileNameMap", fileNameMap);

		if (filename != null) {
			System.out.println(filename);
			String fileSaveRootPath = req.getSession().getServletContext().getRealPath("/resourse/real");// ���ͨ�����·��,��������·��
			FileInfo f = fileInfoService.FindFileByName(filename);
			String dir = fileSaveRootPath + "\\" + f.getTitle() + "\\" + f.getType();
			System.out.println(dir);
			File file = new File(dir + "\\" + filename);
			if (!file.exists()) {

				System.out.println("��Ҫ���ص���Դ�ѱ�ɾ������"); // ��Ϣ��ʾ��
				return "downloadfiles";
			}
			try {
				resp.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
				FileInputStream in = new FileInputStream(dir + "\\" + filename);
				// ���������
				OutputStream out = resp.getOutputStream();
				// ������
				byte[] buffer = new byte[1024];
				int len = 0;
				// ѭ�����������е����ݶ�ȡ������������
				while ((len = in.read(buffer)) > 0) {
					// ��������������ݵ��������ʵ���ļ�����
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("��һ��");
			}

		}

		return "download";
	}

}
