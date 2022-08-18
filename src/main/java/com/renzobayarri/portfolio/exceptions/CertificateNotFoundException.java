package com.renzobayarri.portfolio.exceptions;

public class CertificateNotFoundException extends RuntimeException {

  public CertificateNotFoundException() {
    super("Certificate couldn't be found by indicated id");
  }
}
