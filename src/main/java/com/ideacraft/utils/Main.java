package com.ideacraft.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger logger = LogManager.getLogger();
	public static void main(String[] args) {
		
//		String text = "<script>alert('x');</script>";
		String text = "hello,world";
		
		logger.info(StrUtil.padLeft(text, 15, "0"));
		logger.info(StrUtil.padRight(text, 15, "0"));
		
	}
	
}
