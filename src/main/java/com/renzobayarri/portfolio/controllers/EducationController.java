package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.entities.Education;
import com.renzobayarri.portfolio.services.EducationService;
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
@RequestMapping("/education")
public class EducationController {
  
  @Autowired
  private EducationService educationService;
  
  @GetMapping("/")
  public List<Education> getAll() {
    return educationService.listAllEducations();
  }
  
  @GetMapping("/{id}")
  public Education getOne(@PathVariable int id) {
    return educationService.findEducationById(id);
  }
  
  @PostMapping("/")
  public Education createOne(@RequestBody @Valid Education education) {
    return educationService.createEducation(education);
  }
  
  @PutMapping("/{id}")
  public Education updateOne(@RequestBody @Valid Education education, @PathVariable int id) {
    return educationService.updateEducation(id, education);
  }
  
  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable int id) {
    educationService.deleteEducation(id);
  }
}
