package com.renzobayarri.portfolio.exceptions;

public class CertificateNotFoundException extends Exception {

  public CertificateNotFoundException() {
    super("Certificate couldn't be found by indicated id");
  }
}
