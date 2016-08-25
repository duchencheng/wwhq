package whq.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("filename");

		fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
		String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/files");
		String path = findFileSavePathByFileName(fileSaveRootPath);
		File file = new File(path + "\\" + fileName);
		if (!file.exists()) {
			req.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
			req.getRequestDispatcher("/message.jsp").forward(req, resp);// message.jsp
																		// ��Ϣ��ʾ��
			return;
		}
		String realname = fileName;// ���������ļ���
		// ������Ӧͷ��������������ظ��ļ�
		resp.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		//��ȡҪ���ص��ļ������浽�ļ�������
		FileInputStream in = new FileInputStream(path + "\\" + fileName);
		//���������
		OutputStream out = resp.getOutputStream();
		//������
		byte[] buffer = new byte[1024];
		int len = 0;
		//ѭ�����������е����ݶ�ȡ������������
		while((len = in.read(buffer)) > 0){
			//��������������ݵ��������ʵ���ļ�����
			out.write(buffer, 0, len);
		}
		in.close();
		
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	/**
	 * ͨ���ļ����ʹ洢�ϴ��ļ���Ŀ¼�ҳ�Ҫ���ص��ļ�������·��
	 * 
	 * @param filename
	 *            Ҫ���ص��ļ���
	 * @param saveRootPath
	 *            �ϴ��ļ�����ĸ�Ŀ¼��Ҳ����/WEB-INF/filesĿ¼
	 */
	public String findFileSavePathByFileName(String saveRootPath) {
		String dir = saveRootPath;
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
}