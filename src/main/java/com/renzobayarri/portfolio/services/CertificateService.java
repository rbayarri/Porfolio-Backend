package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Certificate;
import com.renzobayarri.portfolio.exceptions.CertificateNotFoundException;
import com.renzobayarri.portfolio.repositories.CertificateRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CertificateService {

  @Autowired
  private CertificateRepository certificateRepository;

  @Transactional
  public Certificate createCertificate(String name, String idValidation, String institution, LocalDate date) {
    Certificate newCertificate = new Certificate(name, idValidation, institution, date);
    return certificateRepository.save(newCertificate);
  }

  @Transactional
  public Certificate updateCertificate(int id, String name, String idValidation, String institution, LocalDate date) throws CertificateNotFoundException {
    Certificate updatedCertificate = findCertificateById(id);
    updatedCertificate.setName(name);
    updatedCertificate.setIdValidation(idValidation);
    updatedCertificate.setInstitution(institution);
    updatedCertificate.setDate(date);
    return certificateRepository.save(updatedCertificate);
  }

  @Transactional
  public void deleteCertificate(int id) throws CertificateNotFoundException {
    Certificate deletedCertificate = findCertificateById(id);
    certificateRepository.delete(deletedCertificate);
  }

  @Transactional(readOnly = true)
  public Certificate findCertificateById(int id) throws CertificateNotFoundException {
    Optional<Certificate> optionalCertificate = certificateRepository.findById(id);
    return optionalCertificate.orElseThrow(CertificateNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Certificate> listAllCertificates() {
    return certificateRepository.findAll();
  }

}
