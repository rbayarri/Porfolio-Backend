package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Experience;
import com.renzobayarri.portfolio.exceptions.ExperienceNotFoundException;
import com.renzobayarri.portfolio.repositories.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienceService {

  @Autowired
  private ExperienceRepository experienceRepository;

  @Transactional
  public Experience createExperience(Experience experience) {
    return experienceRepository.save(experience);
  }

  @Transactional
  public Experience updateExperience(int id, Experience experience) throws ExperienceNotFoundException {
    if (experienceRepository.existsById(id)) {
      experience.setId(id);
      return experienceRepository.save(experience);
    }
    throw new ExperienceNotFoundException();
  }

  @Transactional
  public void deleteExperience(int id) throws ExperienceNotFoundException {
    if (experienceRepository.existsById(id)) {
      experienceRepository.deleteById(id);
      return;
    }
    throw new ExperienceNotFoundException();
  }

  @Transactional(readOnly = true)
  public Experience findExperienceById(int id) throws ExperienceNotFoundException {
    return experienceRepository.findById(id)
            .orElseThrow(ExperienceNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Experience> listAllExperiences() {
    return experienceRepository.findAll();
  }
}
