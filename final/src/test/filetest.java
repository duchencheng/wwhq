package test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import whq.dao.FileInfoDAO;
import whq.model.FileInfo;


/** �����õ���Spring�Ĳ����� **/
@RunWith(SpringJUnit4ClassRunner.class)

/** ����spring�������ļ�λ�ã�ע�⣺�Ե�ǰ�������λ��Ϊ��׼,�ж�������ļ����ַ��������� **/
@ContextConfiguration(locations={"beans.xml"})
public class filetest {
	@Resource
	private FileInfoDAO fileInfoDao;
	
	
	@Test
	public void findByFileInfoID() {
		// TODO Auto-generated method stub
		System.out.println(123);
		int file_id = 1;
		FileInfo  f= fileInfoDao.findByFileInfoID(file_id);
		dd(f);
		
	}
	@Test
	public void addtest(){
		
		FileInfo f = new FileInfo();
		f.setFile_id(2);
		fileInfoDao.add(f );
		
	}
	public static void dd(FileInfo f){
		System.out.println(f.getDown_count());
		System.out.println(f.getFile_id());
		
	}
	

}
