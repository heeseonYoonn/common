package com.ideacraft.encrypt;
/**
 * 암호화종류 선택 가능
 * 1) 대칭키 암호화 (Symmetric Encryption)
 * 하나의 키로 암호화와 복화를 모두 수행
 * 예) AES(가장 많이 사용-https,vpn,파일암호화 등), DES/3DES(예전방식)
 *-----------------------------------
 * 2) 비대칭키 암호화 (Asymmetric Encryption)
 * 공개키로 암호화, 개인키로 복호화
 * 주로 인증, 키 교환에 사용됨
 * 예) RSA (가장보편적인 암호화 알고리즘-SSL인증서,SSH, 전자서명 등), ECC, DSA
 *-----------------------------------
 * 3) 해시함수 (Hash Function)
 * 일방향 암호화, 복호화 불가능 (비밀번호 저장, 무결성 검사 등에 사용됨)
 *예) SHA-256(가장 많이 사용)
 *
 */
public class CryptoManager {

    private String encryptionType;
    private String cipherType;

    public CryptoManager(String encryptionType){
        this.encryptionType = encryptionType;
    }

    public CryptoManager(String encryptionType, String cipherType){
        this.encryptionType = encryptionType;
        this.cipherType = cipherType;
    }


    public String encrypt(){

        return null;
    }

    public String decrypt(){

        return null;
    }


}
