package com.renzobayarri.portfolio.assemblers;

import com.renzobayarri.portfolio.controllers.ProjectController;
import com.renzobayarri.portfolio.entities.Project;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProjectAssembler implements RepresentationModelAssembler<Project, EntityModel<Project>> {

  @Override
  public EntityModel<Project> toModel(Project entity) {
    return EntityModel.of(entity,
        linkTo(methodOn(ProjectController.class).getOne(entity.getId())).withSelfRel(),
        linkTo(methodOn(ProjectController.class).getAll()).withRel("projects"));
  }
}
