package com.renzobayarri.portfolio.repositories;

import com.renzobayarri.portfolio.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
  
}
