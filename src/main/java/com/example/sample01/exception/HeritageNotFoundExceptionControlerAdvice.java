package com.example.sample01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HeritageNotFoundExceptionControlerAdvice {

  @ResponseBody
  @ExceptionHandler(HeritageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String heritageNotFoundHandler(HeritageNotFoundException e) {
    return e.getMessage();
  }

}
