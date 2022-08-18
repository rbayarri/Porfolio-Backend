package com.renzobayarri.portfolio.exceptions;

public class ExperienceNotFoundException extends RuntimeException {

  public ExperienceNotFoundException() {
    super("Experience couldn't be found by indicated id");
  }
}
