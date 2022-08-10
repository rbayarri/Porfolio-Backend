package com.renzobayarri.portfolio.exceptions;

public class ProjectNotFoundException extends Exception {

  public ProjectNotFoundException() {
    super("Project couldn't be found by indicated id");
  }

}
