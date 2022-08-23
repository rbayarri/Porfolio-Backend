package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.assemblers.TechnologyModelAssembler;
import com.renzobayarri.portfolio.entities.Technology;
import com.renzobayarri.portfolio.exceptions.TechnologyNotFoundException;
import com.renzobayarri.portfolio.services.TechnologyService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
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

  @Autowired
  private TechnologyModelAssembler assembler;

  @GetMapping("")
  public CollectionModel<EntityModel<Technology>> getAll() {

    List<EntityModel<Technology>> technologies = technologyService.listAllTechnologies().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(technologies,
        linkTo(methodOn(TechnologyController.class).getAll()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<Technology> getOne(@PathVariable int id) throws TechnologyNotFoundException {
    return assembler.toModel(technologyService.findTechnologyById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> createOne(@RequestBody @Valid Technology technology) {
    EntityModel<Technology> entityModel = assembler.toModel(technologyService.createTechnology(technology));
    return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOne(@RequestBody @Valid Technology technology, @PathVariable int id) throws TechnologyNotFoundException {
    EntityModel<Technology> entityModel = assembler.toModel(technologyService.updateTechnology(id, technology));
    return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOne(@PathVariable int id) throws TechnologyNotFoundException {
    technologyService.deleteTechnology(id);
    return ResponseEntity.noContent().build();
  }
}
