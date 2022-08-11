package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.entities.Technology;
import com.renzobayarri.portfolio.services.TechnologyService;
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
@RequestMapping("/technology")
public class TechnologyController {
   @Autowired
  private TechnologyService technologyService;

  @GetMapping("/")
  public List<Technology> getAll() {
    return technologyService.listAllTechnologies();
  }

  @GetMapping("/{id}")
  public Technology getOne(@PathVariable int id) {
    return technologyService.findTechnologyById(id);
  }

  @PostMapping("/")
  public Technology createOne(@RequestBody @Valid Technology technology) {
    return technologyService.createTechnology(technology);
  }

  @PutMapping("/{id}")
  public Technology updateOne(@RequestBody @Valid Technology technology, @PathVariable int id) {
    return technologyService.updateTechnology(id, technology);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable int id) {
    technologyService.deleteTechnology(id);
  }
}
