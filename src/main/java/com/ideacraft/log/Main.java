package com.ideacraft.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ideacraft.exception.CustomException;

public class Main {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		try {

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			
		}

	}

	
	public static void test(int i) throws Exception {
		if (i == 1) {
			logger.info("1");
			
		} else if (i == 2) {
			throw new CustomException("99", "USER NOT FOUND");
			
		} else {
			throw new Exception ("Hello, world");
			
		}
	}
}
