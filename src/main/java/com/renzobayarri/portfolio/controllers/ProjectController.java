package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.assemblers.ProjectAssembler;
import com.renzobayarri.portfolio.entities.Project;
import com.renzobayarri.portfolio.exceptions.ProjectNotFoundException;
import com.renzobayarri.portfolio.services.ProjectService;
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
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @Autowired
  private ProjectAssembler assembler;

  @GetMapping("")
  public CollectionModel<EntityModel<Project>> getAll() {
    List<EntityModel<Project>> projects = projectService.listAllProjects().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());
    return CollectionModel.of(projects,
        linkTo(methodOn(ProjectController.class).getAll()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<Project> getOne(@PathVariable int id) throws ProjectNotFoundException {
    return assembler.toModel(projectService.findProjectById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> createOne(@RequestBody @Valid Project project) {
    EntityModel<Project> entity = assembler.toModel(projectService.createProject(project));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOne(@RequestBody @Valid Project project, @PathVariable int id) throws ProjectNotFoundException {
    EntityModel<Project> entity = assembler.toModel(projectService.updateProject(id, project));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOne(@PathVariable int id) throws ProjectNotFoundException {
    projectService.deleteProject(id);
    return ResponseEntity.noContent().build();
  }
}
