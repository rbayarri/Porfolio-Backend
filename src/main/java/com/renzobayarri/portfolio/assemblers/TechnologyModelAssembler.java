package com.renzobayarri.portfolio.assemblers;

import com.renzobayarri.portfolio.controllers.TechnologyController;
import com.renzobayarri.portfolio.entities.Technology;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class TechnologyModelAssembler implements RepresentationModelAssembler<Technology, EntityModel<Technology>>  {

  @Override
  public EntityModel<Technology> toModel(Technology technology) {
    return EntityModel.of(technology,
        linkTo(methodOn(TechnologyController.class).getOne(technology.getId())).withSelfRel(),
        linkTo(methodOn(TechnologyController.class).getAll()).withRel("technologies"));
  }
  
}
