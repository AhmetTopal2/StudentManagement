package com.calculatenote.exception;

import lombok.Getter;


public enum MessageType {

    NO_RECORD_EXIST("1001", "NOT FOUND");

    private final String code;
    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}

