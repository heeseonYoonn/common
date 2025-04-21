package com.ideacraft.email;

public class SenderInfo {
	private String name;
	private String email;
	private String encoding;

	/**
	 * 
	 * @param name : 보내는 사람 이름
	 * @param email : 보내는 사람 메일
	 * @param encoding : 인코딩방식
	 */
	public SenderInfo(String name, String email, String encoding) {
		this.name = name;
		this.email = email;
		this.encoding = encoding;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getEncoding() {
		return encoding;
	}

}
