package com.renzobayarri.portfolio.assemblers;

import com.renzobayarri.portfolio.controllers.ExperienceController;
import com.renzobayarri.portfolio.entities.Experience;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class ExperienceAssembler implements RepresentationModelAssembler<Experience, EntityModel<Experience>>{
  
  @Override
  public EntityModel<Experience> toModel(Experience entity){
    return EntityModel.of(entity,
        linkTo(methodOn(ExperienceController.class).getOne(entity.getId())).withSelfRel(),
        linkTo(methodOn(ExperienceController.class).getAll()).withRel("experiences"));
  }
}
