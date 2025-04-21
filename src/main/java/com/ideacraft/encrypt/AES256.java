package com.ideacraft.encrypt;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 2025. 4. 21.
 * admin
 * AES256
 */
/**
 * 2025. 4. 21.
 * admin
 * AES256
 */
public class AES256 implements Crypto {
	
    // 32바이트(256비트) 키
    private String SECRET_KEY = "12345678901234567890123456789012"; // 32 chars
    // 16바이트(128비트) IV (초기화벡터)
    private String IV = "abcdefghijklmnop"; // 16 chars

    // Cipher 초기화 메서드 (암호화/복호화 공통)
    private Cipher initCipher(int cryptoMode) throws Exception {
        /**
         * Cipher는 암호화 또는 복호화 작업을 수행하기 위한 클래스
         * 암호화 알고리즘, 블록암호화모드, 패딩방식을 지정해서 사용할 수 있음
         * -------------------------------------------
         * 암호화 알고리즘: 블록화된 128비트의 평문을 암호화하는 방식
         * 블록암호화모드: 이 평문을 어떻게 블록들로 나누고 이걸 어떻게 처리할지, 어떤 순서로 처리할지 등
         * 패딩방식: 마지막 블록에 대해 128비트를 못채우는 경우 128비트에 남은 데이터를 어떤방식으로 채울지에 대한 내용
         *-------------------------------------------
         */

        /**
         * CBC의 경우 이전 블록의 암호문과 XOR 연산 후 암호화됨
         * 그래서 첫 블록의 경우 이전 블록이 없으므로 IV (initial vector, 16바이트)를 설정해줘야함
         */
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        /**
         * Spec: 명세서, 정의된 형식, 규격 등을 말함
         * 이 단어가 붙으면 암호화 알고리즘에서 요구하는 특정한 형식의 데이터를 전달하기 위한 wrapper역할을 함
         */
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
        cipher.init(cryptoMode, keySpec, ivSpec);
        return cipher;
    }

    
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = initCipher(Cipher.ENCRYPT_MODE);
        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    
    // 복호화
    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = initCipher(Cipher.DECRYPT_MODE);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, StandardCharsets.UTF_8);
    }

}

