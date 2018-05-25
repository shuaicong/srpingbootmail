package com.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.IMailService;

/**
 * @描述: 
 * @作者: alter
 * @时间：2018年5月24日 下午6:55:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Resource
    IMailService mailService;
    String to = "***@qq.com";
    String subject= "主题aaa";
    String context = "你好，这是个测试";

    @Test
    public void testSendSimpleMail(){
        mailService.sendSimpleEmail(to,subject,context);
    }

    @Test
    public void testHtmlMail(){
        String htmlcontent="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(to,subject,htmlcontent);
    }

    @Test
    public void testFileMail(){
        String filePath = "D:\\测试邮件.docx";
        mailService.sendFileMail(to,subject,context,filePath);
    }

    @Test
    public  void testTemPlate(){
        mailService.sendTemplateMail(to,subject);
    }
    
    @Test  
    public void sendInlineResourceMail() {  
        String rscId = "test006";  
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";  
        String imgPath = "D:\\01.jpg";  
  
        mailService.sendInlineResourceMail(to, "主题：这是有图片的邮件", content, imgPath, rscId);  
    }  
}