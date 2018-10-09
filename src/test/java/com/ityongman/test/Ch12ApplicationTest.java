package com.ityongman.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Ch12ApplicationTest {
	/**
	 * 引入了spring-boot-starter-mail依赖之后，会根据配置文件中的内容去创建JavaMailSender实例
	 */
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine templateEngine;
	
	@Test
	public void sendSimpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("shedunze@163.com");
		message.setTo("2534793812@qq.com");
		message.setSubject("主题:Spring Boot Send Mail Test !!!");
		message.setText("Spring boot Send Mail content !!!");

		javaMailSender.send(message);
	}

	@Test
	public void sendAttachmentsMail() throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setFrom("shedunze@163.com");
		messageHelper.setTo("2534793812@qq.com");
		messageHelper.setSubject("主题:Spring Boot Send Mail With attachment !!!");
		messageHelper.setText("Spring boot Send Mail content With attachment !!!");

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		messageHelper.addAttachment("附件-1.jpg", file);
		messageHelper.addAttachment("附件-2.jpg", file);

		javaMailSender.send(message);
	}

	@Test
	public void sendInlineMail() throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
		messageHelper.setFrom("shedunze@163.com");
		messageHelper.setTo("2534793812@qq.com");
		messageHelper.setSubject("主题:Spring Boot Send Mail With 嵌入静态资源  !!!");
		messageHelper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		messageHelper.addInline("weixin", file); // 需要注意的是addInline函数中资源名称weixin需要与正文中cid:weixin对应起来

		javaMailSender.send(message);
	}

	@Test
	public void sendTemplateMail() throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
		messageHelper.setFrom("shedunze@163.com");
		messageHelper.setTo("2534793812@qq.com");
		messageHelper.setSubject("主题:Spring Boot Send Mail With sendTemplateMail  !!!");
		
		Map<String, Object> model = new HashMap<>();
		model.put("username", "ityongman");
		
		Context context = new Context();
//		context.setVariable("username", "ityongman222");
		context.setVariables(model);
		String emailText = templateEngine.process("message.html", context);
//		System.out.println("Result --> " + emailText);
		
		messageHelper.setText(emailText,true);	
		
		javaMailSender.send(message);
	}
}
