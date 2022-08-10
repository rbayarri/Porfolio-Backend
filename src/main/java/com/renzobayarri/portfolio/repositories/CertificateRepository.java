package com.renzobayarri.portfolio.repositories;

import com.renzobayarri.portfolio.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer>{
  
}
