package com.ideacraft.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 implements Crypto {

	@Override
	public String encrypt(String plainText) throws NoSuchAlgorithmException {
		// SHA-256 알고리즘을 사용하는 MessageDigest 객체 생성
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		//입력받은 평문을 UTF-8 바이트 배열로 변환 후 해시처리
		byte[] hashBytes = md.digest(plainText.getBytes(StandardCharsets.UTF_8));

		StringBuilder sb = new StringBuilder();
		for (byte b : hashBytes) {
			/**
			 * 각 바이트를 16진수로 변경 
			 * %: 포맷 시작을 의미
			 * 02: 두자리로 출력, 자릿수가 부족하면 0으로 채움
			 * x: 16진수 소문자로 출력 (예: 0a, 1f 등)
			 */
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	@Override
	public String decrypt(String plainText) {
		throw new UnsupportedOperationException("SHA-256 is one-way hash algorithm");
	}

}
