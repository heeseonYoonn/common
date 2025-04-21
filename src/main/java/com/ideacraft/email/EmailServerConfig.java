package com.ideacraft.email;

import java.util.Properties;

public class EmailServerConfig extends Properties {

	private static final long serialVersionUID = 1L;

	private String loginId;
	private String passwd;

	/**
	 * 메일서버 설정 클래스
	 * 
	 * @param host: 메일서버 호스트 IP
	 * @param port: 메일서버 포트
	 */
	public EmailServerConfig(String host, String port) {
		this.put("mail.smtp.auth", "true");
		this.put("mail.smtp.starttls.enable", "true");
		this.put("mail.smtp.host", host);
		this.put("mail.smtp.port", port);
		
		//실제 사용 시 프로퍼티 이용
		this.loginId = "wjtmxm7@gmail.com";
		this.passwd = "mnftpkimimxvnvbf";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPasswd() {
		return passwd;
	}

}
