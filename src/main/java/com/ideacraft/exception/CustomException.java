package com.ideacraft.exception;

public class CustomException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public CustomException(String message) {
        super(message);
    }
    
    public CustomException(String errorCode, String message) {
        super("ERROR CODE(" + errorCode + "): " + message);
    }

    public CustomException(String errorCode, String message, Throwable cause) {
        super("ERROR CODE(" + errorCode + "): " + message, cause);

    }

}
