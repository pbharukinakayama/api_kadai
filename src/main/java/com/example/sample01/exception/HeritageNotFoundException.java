package com.example.sample01.exception;

public class HeritageNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public HeritageNotFoundException(Integer heritageId) {
    super("heritageId：" + heritageId + "は存在しません");
  }

}
