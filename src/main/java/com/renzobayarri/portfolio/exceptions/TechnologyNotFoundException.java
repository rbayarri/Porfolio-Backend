package com.renzobayarri.portfolio.exceptions;

public class TechnologyNotFoundException extends Exception {

  public TechnologyNotFoundException() {
    super("Technology couldn't be found by indicated id");
  }

}
