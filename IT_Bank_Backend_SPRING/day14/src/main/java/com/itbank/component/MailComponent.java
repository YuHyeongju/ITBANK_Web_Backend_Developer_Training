package com.itbank.component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailComponent {

	private final String host = "smtp.naver.com";
	private final int port = 465;
	private String serverId = "h980319";
	private String serverPw = "Min%hung159";

	private Properties props;
	
	
	//	@AutoWired가 자동으로 스프링빈을 연결하듯이 
	// @Value는 자동으로 자원(파일)을 연결한다.
	// org.springframework.core.io.Resource
	// classpath:"src/main/java" or "src/main/resources"
	@Value("classpath:mailForm.html")
	private Resource mailForm;

	@PostConstruct // 생성자 호출 이후에 실행할 것
	private void init() {
		props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

	}

	// 단순 텍스트 메일 보내기
	public int sendSimpleMessage(String address, String content, String subject) {
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = serverId;
			String pw = serverPw;

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		mailSession.setDebug(true);

		// 2) 보낼 메시지 작성
		Message message = new MimeMessage(mailSession);

		try {
			message.setFrom(new InternetAddress(serverId + "@naver.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
			message.setSubject(subject); // 제목
			message.setText(content); // 내용

			Transport.send(message); // 3) 준비된 메일을 보낸다.

			return 1;
		} catch (MessagingException e) {

			e.printStackTrace();
			return 0;
		}

	}

	public int sendMimeMessage(HashMap<String, String> param) {
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
			String un = serverId;
			String pw = serverPw;

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		mailSession.setDebug(true);

		Message message = new MimeMessage(mailSession);
		String address = param.get("address");
		String subject = param.get("subject");
		String content = param.get("content");

		try {
			message.setFrom(new InternetAddress(serverId + "@naver.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
			message.setSubject(subject); // 제목
			// message.setText(content); // 내용, 단순 텍스트
			String tag = "";
			
			Scanner	sc = new Scanner(mailForm.getFile());
			
			while(sc.hasNextLine()) {
				tag += sc.nextLine();
			}
			sc.close();
//			tag += "<div style=\"padding:10px; font-size: 100px; margin: 20px auto;\">";
//			tag += "		<p>인증번호는 [%s] 입니다.</p>";
//			tag += "</div>";
			// 이 방법을 사용하면 태그에 스타일을 작성해야 스타일이 먹힌다.

			content = String.format(tag, content);

			message.setContent(content, "text/html; charset=utf-8"); // 태그 포함 내용

			Transport.send(message); // 3) 준비된 메일을 보낸다.

			return 1;
		} catch (MessagingException  | IOException e) {

			e.printStackTrace();
			return 0;
		}

	}
}
