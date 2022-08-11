package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.entities.Certificate;
import com.renzobayarri.portfolio.services.CertificateService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificate")
public class CertifcateController {
  
  @Autowired
  private CertificateService certificateService;
  
  @GetMapping("/")
  public List<Certificate> getAll() {
    return certificateService.listAllCertificates();
  }
  
  @GetMapping("/{id}")
  public Certificate getOne(@PathVariable int id) {
    return certificateService.findCertificateById(id);
  }
  
  @PostMapping("/")
  public Certificate createOne(@RequestBody @Valid Certificate certificate) {
    return certificateService.createCertificate(certificate);
  }
  
  @PutMapping("/{id}")
  public Certificate updateOne(@RequestBody @Valid Certificate certificate, @PathVariable int id) {
    return certificateService.updateCertificate(id, certificate);
  }
  
  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable int id) {
    certificateService.deleteCertificate(id);
  }
  
}
