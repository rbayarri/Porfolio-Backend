package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Education;
import com.renzobayarri.portfolio.exceptions.EducationNotFoundException;
import com.renzobayarri.portfolio.repositories.EducationRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EducationService {

  @Autowired
  EducationRepository educationRepository;

  @Transactional
  public Education createEducation(String carrer, String institution, LocalDate startDate, LocalDate finishDate) {
    Education newEducation = new Education(carrer, institution, startDate, finishDate);
    return educationRepository.save(newEducation);
  }

  @Transactional
  public Education updateEducation(int id, String carrer, String institution, LocalDate startDate, LocalDate finishDate) throws EducationNotFoundException {
    Education updatedEducation = findEducationById(id);
    updatedEducation.setCarrer(carrer);
    updatedEducation.setInstitution(institution);
    updatedEducation.setStartDate(startDate);
    updatedEducation.setFinishDate(finishDate);
    return educationRepository.save(updatedEducation);
  }

  @Transactional
  public void deleteEducation(int id) throws EducationNotFoundException {
    Education deletedEducation = findEducationById(id);
    educationRepository.delete(deletedEducation);
  }

  @Transactional(readOnly = true)
  public Education findEducationById(int id) throws EducationNotFoundException {
    Optional<Education> optionalEducation = educationRepository.findById(id);
    return optionalEducation.orElseThrow(EducationNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Education> listAllEducations() {
    return educationRepository.findAll();
  }
}
