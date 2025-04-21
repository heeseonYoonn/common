package com.ideacraft.email;

public class EmailContent {

	private String title;
	private String content;

	/**
	 * 전송메일 내용
	 * 
	 * @param title
	 * @param content
	 */
	public EmailContent(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}
