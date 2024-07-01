package com.ideacraft.mail;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailUtil {
	
	
	public boolean sendMail(List<String> recipientList, Map<String, String> mailContents) throws Exception{
		boolean result;
			// 보내는 사람 설정 (고정)
			InternetAddress fromAddr = new InternetAddress();
			fromAddr.setPersonal("서비스명", "UTF-8");
			fromAddr.setAddress("noreply@gmail.com");

			/*
			 * 메일계정 로그인id, 비밀번호 (고정) 프로퍼티에 id,pw 암호화 -> 복호화해서 넣기
			 */
			String googleLoginId = "wjtmxm7@gmail.com";
			String googleAppPasswd = "mnftpkimimxvnvbf";

			Properties smtpProps = new Properties();
			// property 처리
			smtpProps.put("mail.smtp.auth", "true");
			smtpProps.put("mail.smtp.starttls.enable", "true");
			smtpProps.put("mail.smtp.host", "smtp.gmail.com");
			smtpProps.put("mail.smtp.port", "587");

			// 받는사람 이메일
			InternetAddress[] toAddr = new InternetAddress[recipientList.size()];
			for (int i = 0; i < recipientList.size(); i++) {
				toAddr[i] = new InternetAddress(recipientList.get(i));
			}

			// 메세지 생성
			Session session = Session.getDefaultInstance(smtpProps, null);
			Message message = new MimeMessage(session);
			message.setFrom(fromAddr);
			message.setSubject(mailContents.get("mailTitle"));
			message.setContent(mailContents.get("mailHtml"), "text/html; charset=UTF-8");
			message.addRecipients(Message.RecipientType.TO, toAddr);

			// 메세지 전송
			Transport.send(message, googleLoginId, googleAppPasswd);
			result = true;

		return result;
	}

}
