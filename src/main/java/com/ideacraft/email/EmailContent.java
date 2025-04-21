package com.ideacraft.email;

public class EmailContent {

	private String title; 
	private String content;

	/**
	 * 
	 * @param title: 메일제목
	 * @param content: 메일내용
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
