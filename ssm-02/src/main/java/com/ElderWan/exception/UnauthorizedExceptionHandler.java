package com.ElderWan.exception;


import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class UnauthorizedExceptionHandler {
    @ExceptionHandler({UnauthorizedException.class})
public  String   UnauthorizedException(){

        System.out.println("=============================");

        return "exception";
}

}
