package com.ideacraft.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailController {

	private final Logger logger = LogManager.getLogger();

	public String sendMail() {
		System.out.println("SEND MAIL TEST");
		try {

			List<String> recipientList = new ArrayList<>();
			// from DB
			recipientList.add("hee_place@naver.com");
			recipientList.add("wjtmxm7@gmail.com");

			Map<String, String> mailContent = new HashMap<>();
			// value 수정
			mailContent.put("mailTitle", "[Test]");
			mailContent.put("mailHtml", "This is test mail");

			// sender

			// smtp 서버 정보, 메일 내용, 받는 사람리스트

			MailUtil mailUtil = new MailUtil();
			// 받는사람, 메일내용을 넘김
			mailUtil.sendMail(recipientList, mailContent);

		} catch (Exception e) {
			logger.error(e);
		}
		return "index";
	}

}
