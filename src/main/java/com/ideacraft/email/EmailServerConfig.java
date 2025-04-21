package com.ideacraft.email;

import java.util.Properties;

public class EmailServerConfig extends Properties {

	/**
	 * Properties 클래스는 Serializable을 구현하고 있음. 따라서 이 클래스를 상속한 경우, 세션 클러스터링이나 네트워크를 통해
	 * 객체를 전송해야 할 때 직렬화/역직렬화가 필요할 수 있음. 단, 메일 전송 시에는 해당 객체를 네트워크에 직접 전송하지 않으므로, 직렬화가
	 * 직접적으로 사용되지는 않음.
	 */
	private static final long serialVersionUID = 1L;

	private String loginId;
	private String passwd;

	public EmailServerConfig(String host, String port) {
		this.put("mail.smtp.auth", "true");
		this.put("mail.smtp.starttls.enable", "true");
		this.put("mail.smtp.host", host);
		this.put("mail.smtp.port", port);
		
		//실제 사용 시 프로퍼티로 가져오기
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
