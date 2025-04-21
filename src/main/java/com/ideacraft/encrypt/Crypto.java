package com.ideacraft.encrypt;

public interface Crypto {
	
	String encrypt (String plainText) throws Exception;
	String decrypt (String plainText) throws Exception;
	

}
