package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.assemblers.ExperienceAssembler;
import com.renzobayarri.portfolio.entities.Experience;
import com.renzobayarri.portfolio.exceptions.ExperienceNotFoundException;
import com.renzobayarri.portfolio.services.ExperienceService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

  @Autowired
  private ExperienceService experienceService;

  @Autowired
  private ExperienceAssembler assembler;

  @GetMapping("")
  public CollectionModel<EntityModel<Experience>> getAll() {
    List<EntityModel<Experience>> experiences = experienceService.listAllExperiences().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(experiences,
        linkTo(methodOn(ExperienceController.class).getAll()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<Experience> getOne(@PathVariable int id) throws ExperienceNotFoundException {
    return assembler.toModel(experienceService.findExperienceById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> createOne(@RequestBody @Valid Experience experience) {
    EntityModel<Experience> entity = assembler.toModel(experienceService.createExperience(experience));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOne(@RequestBody @Valid Experience experience, @PathVariable int id) throws ExperienceNotFoundException {
    EntityModel<Experience> entity = assembler.toModel(experienceService.updateExperience(id, experience));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOne(@PathVariable int id) throws ExperienceNotFoundException {
    experienceService.deleteExperience(id);
    return ResponseEntity.noContent().build();
  }
}
