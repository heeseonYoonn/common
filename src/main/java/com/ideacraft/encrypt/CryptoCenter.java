package com.ideacraft.encrypt;

public class CryptoCenter {

	private Crypto crypto;

	public CryptoCenter(String encryptionType) {
		if (encryptionType.equals("AES256")) {
			crypto = new AES256();

		} else if (encryptionType.equals("SHA256")) {
			crypto = new SHA256();
		}
	}

	public String encrypt(String plainText) throws Exception {
		return crypto.encrypt(plainText);
	}

	public String decrypt(String plainText) throws Exception {
		return crypto.decrypt(plainText);
	}

}
