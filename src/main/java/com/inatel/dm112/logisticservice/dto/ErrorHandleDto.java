package com.inatel.dm112.logisticservice.dto;

public class ErrorHandleDto {

  private int code;
  private String message;

  public ErrorHandleDto(String message, int code) {
    super();
    this.code = code;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public int getCode() {
    return code;
  }
}
