package test;



import java.io.File;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
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
  //  @Resource
   // private IUserService1 userService;
    @Resource
    private IFileInfoService fileInfoService;
    //@Test // ����������20�����ݣ� ע��������ʱ���Ȱ�����ע����Ҫ����ع�����
    public void testadd() {
    	String file_name = "README.html";
    	System.out.println(1);
    	FileInfo f = fileInfoService.FindFileByName(file_name);
    	System.out.println(f.getTitle());
      
    }
    @Test // ����������20�����ݣ� ע��������ʱ���Ȱ�����ע����Ҫ����ع�����
    public void testad() {
   Timestamp t =new Timestamp(new Date().getTime()); 
    	fileInfoService.UpDate(1, "wer", (byte)1, t);
	
      
    }
   
   
}