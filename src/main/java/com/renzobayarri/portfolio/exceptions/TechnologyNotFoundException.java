package com.renzobayarri.portfolio.exceptions;

public class TechnologyNotFoundException extends RuntimeException {

  public TechnologyNotFoundException() {
    super("Technology couldn't be found by indicated id");
  }

}
