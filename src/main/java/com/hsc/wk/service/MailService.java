package com.hsc.wk.service;

public interface MailService {
    public void sendSimpleMail(String to,String subject,String content);
    public void sendHtmlMail(String to,String subject,String content) throws Exception;
    public void sendAttachmentMail(String to,String subject,String content,String filepath)throws Exception;
    public void sendImageMail(String to,String subject,String content,String rscPath,String rscId);
}
