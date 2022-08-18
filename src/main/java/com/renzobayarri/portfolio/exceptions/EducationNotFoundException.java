package com.renzobayarri.portfolio.exceptions;

public class EducationNotFoundException extends RuntimeException {

  public EducationNotFoundException() {
    super("Education couln't be found by indicated id");
  }

}
