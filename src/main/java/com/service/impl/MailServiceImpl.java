package com.service.impl;

import com.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @描述: 
 * @作者: alter
 * @时间：2018年5月24日 下午6:55:47
 */
@Component
public class MailServiceImpl implements IMailService{

    @Autowired
    private JavaMailSender mailSender;


    @Resource
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String mailFrom;

    /**
     * 发送简单邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendSimpleEmail(String to,String subject,String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * 发送html邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(mailFrom);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filepath
     */
    @Override
    public void sendFileMail(String to, String subject, String content, String filepath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(mailFrom);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource file = new FileSystemResource(new File(filepath));
            String fileName = filepath.substring(filepath.lastIndexOf(File.separator));
            helper.addAttachment(fileName,file);

            mailSender.send(mimeMessage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 使用模板来发送邮件
     *
     * @param to
     * @param subject
     */
    @Override
    public void sendTemplateMail(String to, String subject) {
        Context context = new Context();
        context.setVariable("username","jantent");
        String mailHtml =templateEngine.process("mail",context);
        sendHtmlMail(to,subject,mailHtml);
    }
    
    /**  
     * 发送正文中有静态资源（图片）的邮件  
     * @param to  
     * @param subject  
     * @param content  
     * @param rscPath  
     * @param rscId  
     */  
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){  
        MimeMessage message = mailSender.createMimeMessage();  
  
        try {  
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  
            helper.setFrom(mailFrom);  
            helper.setTo(to);  
            helper.setSubject(subject);  
            helper.setText(content, true);  
  
            FileSystemResource res = new FileSystemResource(new File(rscPath));  
            helper.addInline(rscId, res);  
  
            mailSender.send(message);  
        } catch (MessagingException e) {  
        	e.printStackTrace();
        }  
    }  
}
