package com.ideacraft.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StrUtil {

	private static final Logger logger = LogManager.getLogger();

	// JVM 기본 문자 인코디 확인
	public static String getCharacterSet() {
		return "SYSTEM CHARACTER SET: " + Charset.defaultCharset().name();
	}

	// NULL, EMPTY 체크
	public static boolean isEmpty(String text) {
		return text == null || text.trim().isEmpty() || text.equalsIgnoreCase("null");
	}

	// 공백포함여부확인
	public static boolean containsWhiteSpace(String text) {
		return text == null ? false : text.matches(".*\\s+.*");
	}

	// 문자열 내 모든 공백제거
	public static String removeAllWhiteSpace(String text) {
		if (text == null) {
			return null;

		} else {

			StringBuilder result = new StringBuilder();

			for (char element : text.toCharArray()) {
				if (!Character.isWhitespace(element)) {
					result.append(element);
				}
			}

			return result.toString();
		}
	}

	// 문자열 앞 뒤 공백 제거
	public static String trim(String text) {
		return text == null ? null : text.trim();

	}

	// 특수문자 포함 여부
	public static boolean containsStrictSpecialChars(String text) {
		char[] blockedChars = { '<', '>', '"', '\'', '/', '(', ')', '=', ';', '&' };
		return containsAny(text, blockedChars);
	}

	// 특수문자 포함 여부
	public static boolean containsGeneralSpecialChars(String text) {
		char[] blockedChars = { '<', '>', '\'', '"', '=' };
		return containsAny(text, blockedChars);
	}

	// 특수문자 포함 여부 (공통)
	public static boolean containsAny(String text, char[] blockedChars) {
		if (text == null) {
			return false;

		} else {
			for (char element : blockedChars) {
				if (text.indexOf(element) != -1) {
					return true;

				}
			}
			return false;
		}
	}
	
	//전화번호

	
	/**
	 * 
	 * @Date  2025. 4. 22.
	 * @param text 문자열
	 * @param size 희망하는 문자열의 사이즈
	 * @param padChar padding할 문자
	 * @return paddedText
	 */
	public static String padLeft(String text, int size, String padChar) {
		String paddedText = "";
		if (text == null) {
			// Do nothing

		} else {
			int padLength = size - text.length();
			
			if (padLength > 0) {
				StringBuilder stringBuilder = new StringBuilder();
				for (int i = 0; i < padLength; i++) {
					stringBuilder.append(padChar);
				}
				
				paddedText = (stringBuilder.append(text)).toString();

			} else {
				paddedText = text;
			}

		}
		return paddedText;
	}


	/**
	 * 
	 * @Date  2025. 4. 22.
	 * @param text 문자열
	 * @param size 희망하는 문자열의 사이즈
	 * @param padChar padding할 문자
	 * @return paddedText
	 */
	public static String padRight(String text, int size, String padChar) {
		String paddedText = "";
		if (text == null) {
			// Do nothing

		} else {
			int padLength = size - text.length();
			
			if (padLength > 0) {
				StringBuilder stringBuilder = new StringBuilder(text);
				for (int i = 0; i < padLength; i++) {
					stringBuilder.append(padChar);
				}
				
				paddedText = stringBuilder.toString();

			} else {
				paddedText = text;
			}

		}
		return paddedText;
	}


	// 마스킹처리

	// 문자열검색

	// 길이초과시 ...으로 축약

	// 특수문자 대체

}
