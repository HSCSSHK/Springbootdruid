package com.hsc.wk.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestMailService {
    @Autowired
    private MailService mailService;


    /**
     *  简单文本邮件发送
     */
    @Test
    public void sendSimpleMailTest(){
        //mailService.sendSimpleMail("xxxxxxxxxxxxx@163.com","简单文本邮件","这是我的springboot邮件,哈哈...");
        mailService.sendSimpleMail("xxxxxxxxxxx@qq.com","简单文本邮件","这是我的springboot邮件,哈哈...");

    }
}
