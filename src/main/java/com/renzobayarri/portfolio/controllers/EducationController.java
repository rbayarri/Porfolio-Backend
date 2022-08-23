package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.assemblers.EducationAssembler;
import com.renzobayarri.portfolio.entities.Education;
import com.renzobayarri.portfolio.exceptions.EducationNotFoundException;
import com.renzobayarri.portfolio.services.EducationService;
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
@RequestMapping("/education")
public class EducationController {

  @Autowired
  private EducationService educationService;

  @Autowired
  private EducationAssembler assembler;

  @GetMapping("")
  public CollectionModel<EntityModel<Education>> getAll() {

    List<EntityModel<Education>> listEducation = educationService.listAllEducations().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(listEducation,
        linkTo(methodOn(EducationController.class).getAll()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<Education> getOne(@PathVariable int id) throws EducationNotFoundException {
    return assembler.toModel(educationService.findEducationById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> createOne(@RequestBody @Valid Education education) {
    EntityModel<Education> entity = assembler.toModel(educationService.createEducation(education));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOne(@RequestBody @Valid Education education, @PathVariable int id) throws EducationNotFoundException {
    EntityModel<Education> entity = assembler.toModel(educationService.updateEducation(id, education));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOne(@PathVariable int id) throws EducationNotFoundException {
    educationService.deleteEducation(id);
    return ResponseEntity.noContent().build();
  }
}
