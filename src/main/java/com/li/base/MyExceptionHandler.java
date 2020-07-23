package com.li.base;

import com.li.exception.SQLErrorException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(SQLErrorException.class)
    public void handler(Exception e) {
        System.out.println(e.getMessage());
        System.out.println("SQLExceptionHandler.....");
    }
}
