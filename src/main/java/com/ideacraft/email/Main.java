package com.ideacraft.email;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		try {
			
			//실제 사용시 하드코딩 된 부분은 .properties 파일 이용
			EmailSenderInfo googleSenderInfo = new EmailSenderInfo("noreply", "noreply@gmail.com", "UTF-8");
			EmailServerConfig googleSmtpConfig = new EmailServerConfig("smtp.gmail.com", "587");
			EmailService emailService = new EmailService(googleSenderInfo, googleSmtpConfig);
			EmailContent mailContent = new EmailContent("TestTitle", emailService.readHtmlAsString(""));

			
			// 보내는사람 목록 (DB에서 목록을 가져옴, 임시 하드코딩)
			List<String> recipientList = new ArrayList<>();
			recipientList.add("hee_place@naver.com");
			recipientList.add("wjtmxm7@gmail.com");
			

			//전송목록, 메일 내용 전달
			boolean isSussedSendingMail = emailService.sendMail(recipientList, mailContent);
			logger.info("isSussedSendingMail: {}", isSussedSendingMail);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}

	}
}
