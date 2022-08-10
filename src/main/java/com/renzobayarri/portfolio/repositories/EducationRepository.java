package com.renzobayarri.portfolio.repositories;

import com.renzobayarri.portfolio.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
  
}
