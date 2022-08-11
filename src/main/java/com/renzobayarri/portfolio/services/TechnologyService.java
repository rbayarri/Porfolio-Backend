package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Technology;
import com.renzobayarri.portfolio.exceptions.TechnologyNotFoundException;
import com.renzobayarri.portfolio.repositories.TechnologyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechnologyService {

  @Autowired
  TechnologyRepository technologyRepository;

  @Transactional
  public Technology createTechnology(Technology technology) {
    return technologyRepository.save(technology);
  }

  @Transactional
  public Technology updateTechnology(int id, Technology technology) throws TechnologyNotFoundException {
    if (technologyRepository.existsById(id)) {
      technology.setId(id);
      return technologyRepository.save(technology);
    }
    throw new TechnologyNotFoundException();
  }

  @Transactional
  public void deleteTechnology(int id) throws TechnologyNotFoundException {
    if (technologyRepository.existsById(id)) {
      technologyRepository.deleteById(id);
    }
    throw new TechnologyNotFoundException();
  }

  @Transactional(readOnly = true)
  public Technology findTechnologyById(int id) throws TechnologyNotFoundException {
    return technologyRepository.findById(id)
            .orElseThrow(TechnologyNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Technology> listAllTechnologies() {
    return technologyRepository.findAll();
  }

}
