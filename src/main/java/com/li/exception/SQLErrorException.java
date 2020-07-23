package com.li.exception;

public class SQLErrorException extends Exception{

    public SQLErrorException(String message) {
        super(message);
        System.out.println(message);
    }
}
