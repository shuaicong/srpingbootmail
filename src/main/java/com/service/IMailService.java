package com.service;

/**
 * @描述: 
 * @作者: alter
 * @时间：2018年5月24日 下午6:55:53
 */
public interface IMailService {
    /**
     * 发送简单邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleEmail(String to, String subject, String content);

    /**
     * 发送html邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filepath
     */
    void sendFileMail(String to, String subject, String content, String filepath);

    /**
     * 使用模板来发送邮件
     *
     * @param to
     * @param subject
     */
    void sendTemplateMail(String to, String subject);
    
    /**  
     * 发送正文中有静态资源（图片）的邮件  
     * @param to  
     * @param subject  
     * @param content  
     * @param rscPath  
     * @param rscId  
     */  
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
