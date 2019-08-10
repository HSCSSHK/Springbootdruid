package com.hsc.wk.service.impl;

import com.hsc.wk.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by ${hsc} on 2019/7/27
 */

@Slf4j
@Service
public class MailServicelmp implements MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    /**
     *  发送文本邮件
     *
     * @param to  接收人
     * @param subject 主题
     * @param content  邮件内容
     */
    @Override
    public void sendSimpleMail(String to,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(from);
        mailSender.send(message);

    }

    /**
     *   发送HTML邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendHtmlMail(String to,String subject,String content) throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(mimeMessage);
    }
    /**
     *  发送带附本的邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendAttachmentMail(String to,String subject,String content,String filepath) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);

        //文件流:获取本地文件
        FileSystemResource file = new FileSystemResource(new File(filepath));
        String filename = file.getFilename();
        //可以发送多个
        helper.addAttachment(filename,file);
        // helper.addAttachment(filename+"_test",file);

        //进行发送
        mailSender.send(message);
    }

    /**
     *  发送图片邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @throws Exception
     */
    @Override
    public void sendImageMail(String to,String subject,String content,String rscPath,String rscId){
        log.info("发送静态邮件开始: {},{},{},{},{}",to,subject,content,rscPath,rscId);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try{
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource file = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId,file);
            mailSender.send(message);
            log.info("发送静态图片邮件成功!");
        }catch (Exception e){
            log.error("发送静态邮件失败!",e);
        }

    }
}
