package com.ideacraft.email;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailService {

	private static final Logger logger = LogManager.getLogger();

	private SenderInfo senderInfo;
	private EmailServerConfig emailServerConfig;

	/**
	 * 
	 * @param senderInfo: 보내는 사람 정보
	 */
	public EmailService(SenderInfo senderInfo, EmailServerConfig emailServerConfig) {
		this.senderInfo = senderInfo;
		this.emailServerConfig = emailServerConfig;
	}

	/**
	 * 메일전송
	 * 
	 * @Date : 2025. 4. 21.
	 * @Auther : admin
	 * @Return : boolean: 메일전송 성공여부
	 */
	public boolean sendMail(List<String> recipientList, EmailContent emailContent) {
		boolean result = false;

		try {
			// 보내는 사람 주소
			InternetAddress fromAddr = new InternetAddress();
			fromAddr.setPersonal(senderInfo.getName(), senderInfo.getEncoding());
			fromAddr.setAddress(senderInfo.getEmail());

			// 받는사람 주소
			InternetAddress[] toAddr = new InternetAddress[recipientList.size()];
			for (int i = 0; i < recipientList.size(); i++) {
				toAddr[i] = new InternetAddress(recipientList.get(i));
			}

			// 메세지 생성
			Session session = Session.getDefaultInstance(emailServerConfig, null);
			Message message = new MimeMessage(session);
			message.setFrom(fromAddr);
			message.setSubject(emailContent.getTitle());
			message.setContent(emailContent.getContent(), "text/html; charset=UTF-8");
			message.addRecipients(Message.RecipientType.TO, toAddr);

			// 전송
			Transport.send(message, emailServerConfig.getLoginId(), emailServerConfig.getPasswd());
			result = true;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return result;

		}

		return result;
	}

	/**
	 * 이메일 내용으로 보내고자하는 html파일을 String으로 읽어옴
	 * 
	 * @Date : 2025. 4. 21.
	 * @Auther : admin
	 * @Return : String: html 파일 내용을 String으로 변환시켜 반환
	 */
	public String readHtmlAsString(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
	}

}
