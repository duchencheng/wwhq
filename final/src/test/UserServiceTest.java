package test;









import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import whq.model.FileInfo;
import whq.model.User1;
import whq.service.imp.IFileInfoService;
import whq.service.imp.IUserService1;


/** �����õ���Spring�Ĳ����� **/
@RunWith(SpringJUnit4ClassRunner.class)

/** ����spring�������ļ�λ�ã�ע�⣺�Ե�ǰ�������λ��Ϊ��׼,�ж�������ļ����ַ��������� **/
@ContextConfiguration(locations={"beans.xml"})



public class UserServiceTest {
   @Resource
  private IUserService1 userService;
   // @Resource
   // private IFileInfoService fileInfoService;
    //@Test // ����������20�����ݣ� ע��������ʱ���Ȱ�����ע����Ҫ����ع�����
    public void testadd() {
    	String file_name = "README.html";
    	System.out.println(1);
    	//FileInfo f = fileInfoService.FindFileByName(file_name);
    //	System.out.println(f.getTitle());
      
    }
    @Test // ����������20�����ݣ� ע��������ʱ���Ȱ�����ע����Ҫ����ع�����
    public void testad() {	
    	User1 u= new User1();
    	u.setIsAdmin((byte)1);
    	u.setPassword("1");
    	u.setProfession("��˵���ķ���");
    	u.setUser_name("weh");
    	u.setUser_id(1002);
		//userService.update(u);
    //	userService.add(u);
    	List<User1> t = userService.list();
    	Iterator it=t.iterator();  
        
    	while(it.hasNext())  
    	{  
    	    System.out.println(it.next());  
    	}  
    	//userService.delete(1002);
      
    }
   
   
}