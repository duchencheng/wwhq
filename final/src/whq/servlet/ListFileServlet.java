package whq.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �г�webϵͳ�����������ļ�
 * 
 * @author lenovo
 *
 */
public class ListFileServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ�ϴ��ļ���Ŀ¼
		String uploadFilePath = this.getServletContext().getRealPath("/resourse/template");

		Map<String, String> fileNameMap = new HashMap<String, String>();
		// �ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
		listfile(new File(uploadFilePath), fileNameMap);
		// ��Map���Ϸ��͵�listfile.jspҳ�������ʾ
		req.setAttribute("fileNameMap", fileNameMap);
		req.getRequestDispatcher("/listfile.jsp").forward(req, resp);
	}

	/**
	 * �ݹ����ָ��Ŀ¼�µ������ļ� ���ܻ����ظ��������ļ�
	 * 
	 * @param file
	 * @param map
	 */
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

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
