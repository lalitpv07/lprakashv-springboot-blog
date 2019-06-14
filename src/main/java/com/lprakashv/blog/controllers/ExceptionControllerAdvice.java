package com.lprakashv.blog.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
  @ExceptionHandler(RuntimeException.class)
  public String rt(RuntimeException e) {
    return "RuntimeException";
  }

  @ExceptionHandler(Exception.class)
  public String e(Exception e) {
    return "Exception";
  }
}
