package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Education;
import com.renzobayarri.portfolio.exceptions.EducationNotFoundException;
import com.renzobayarri.portfolio.repositories.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EducationService {

  @Autowired
  EducationRepository educationRepository;

  @Transactional
  public Education createEducation(Education education) {
    return educationRepository.save(education);
  }

  @Transactional
  public Education updateEducation(int id, Education education) throws EducationNotFoundException {
    if (educationRepository.existsById(id)) {
      education.setId(id);
      return educationRepository.save(education);
    }
    throw new EducationNotFoundException();
  }

  @Transactional
  public void deleteEducation(int id) throws EducationNotFoundException {
    if (educationRepository.existsById(id)) {
      educationRepository.deleteById(id);
      return;
    }
    throw new EducationNotFoundException();
  }

  @Transactional(readOnly = true)
  public Education findEducationById(int id) throws EducationNotFoundException {
    return educationRepository.findById(id)
            .orElseThrow(EducationNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Education> listAllEducations() {
    return educationRepository.findAll();
  }
}
