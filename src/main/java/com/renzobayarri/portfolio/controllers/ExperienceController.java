package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.entities.Experience;
import com.renzobayarri.portfolio.exceptions.ExperienceNotFoundException;
import com.renzobayarri.portfolio.services.ExperienceService;
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
@RequestMapping("/experience")
public class ExperienceController {

  @Autowired
  private ExperienceService experienceService;

  @GetMapping("")
  public List<Experience> getAll() {
    return experienceService.listAllExperiences();
  }

  @GetMapping("/{id}")
  public Experience getOne(@PathVariable int id) throws ExperienceNotFoundException {
    return experienceService.findExperienceById(id);
  }

  @PostMapping("")
  public Experience createOne(@RequestBody @Valid Experience experience) {
    return experienceService.createExperience(experience);
  }

  @PutMapping("/{id}")
  public Experience updateOne(@RequestBody @Valid Experience experience, @PathVariable int id) throws ExperienceNotFoundException {
    return experienceService.updateExperience(id, experience);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable int id) throws ExperienceNotFoundException {
    experienceService.deleteExperience(id);
  }
}
