package com.renzobayarri.portfolio.exceptions;

public class ExperienceNotFoundException extends Exception {

  public ExperienceNotFoundException() {
    super("Experience couldn't be found by indicated id");
  }
}
