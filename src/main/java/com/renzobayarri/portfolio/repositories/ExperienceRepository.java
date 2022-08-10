package com.renzobayarri.portfolio.repositories;

import com.renzobayarri.portfolio.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
  
}
