# Springboot-druid
springboot基本框架搭建

# springboot 整合基本框架
# 技术栈  

## 后端技术栈

后端主要采用了：  

1.SpringBoot  
2.druid  
3.MyBatis（实现注解，xml）
4.MySQL
5.MyBatis 逆向工程  
6.部分接口遵循Restful风格  
7.发邮件
8.logback日志

# 快速运行 

1.克隆本项目到本地 

2.建表
CREATE TABLE `userbase` (
  `id` int(12) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
3.
把数据链接地址，账号，密码，改成自己的数据配置
spring.datasource.url=jdbc:mysql://192.168.125.128:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true
spring.datasource.username=root
spring.datasource.password=root
4.
发邮件，改成自己申请的邮箱，改成自己申请的客户端授权码。这里是使用163邮箱，可以改成其它邮箱地址

用户名
spring.mail.username=xxxxxxxxxxxxxxxxx@163.com
开启POP3之后设置的客户端授权码
spring.mail.password=xxxxxxxxxxxxxx

项目下src/test/java/com/hsc/wk/service/TestMailService 下的测试邮箱可以改成自己想发送的。

