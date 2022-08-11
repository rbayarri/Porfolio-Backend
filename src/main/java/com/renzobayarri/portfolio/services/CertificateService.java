package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Certificate;
import com.renzobayarri.portfolio.exceptions.CertificateNotFoundException;
import com.renzobayarri.portfolio.repositories.CertificateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CertificateService {

  @Autowired
  private CertificateRepository certificateRepository;

  @Transactional
  public Certificate createCertificate(Certificate certificate) {
    return certificateRepository.save(certificate);
  }

  @Transactional
  public Certificate updateCertificate(int id, Certificate certificate) throws CertificateNotFoundException {
    if (certificateRepository.existsById(id)) {
      certificate.setId(id);
      return certificateRepository.save(certificate);
    }
    throw new CertificateNotFoundException();
  }

  @Transactional
  public void deleteCertificate(int id) throws CertificateNotFoundException {
    if (certificateRepository.existsById(id)) {
      certificateRepository.deleteById(id);
      return;
    }
    throw new CertificateNotFoundException();
  }

  @Transactional(readOnly = true)
  public Certificate findCertificateById(int id) throws CertificateNotFoundException {
    return certificateRepository.findById(id)
            .orElseThrow(CertificateNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Certificate> listAllCertificates() {
    return certificateRepository.findAll();
  }

}
