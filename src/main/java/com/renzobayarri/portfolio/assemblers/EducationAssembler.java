
package com.renzobayarri.portfolio.assemblers;

import com.renzobayarri.portfolio.controllers.EducationController;
import com.renzobayarri.portfolio.entities.Education;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class EducationAssembler implements RepresentationModelAssembler<Education, EntityModel<Education>> {

  @Override
  public EntityModel<Education> toModel(Education entity) {
    return EntityModel.of(entity,
        linkTo(methodOn(EducationController.class).getOne(entity.getId())).withSelfRel(),
        linkTo(methodOn(EducationController.class).getAll()).withRel("list of education"));
  }
  
}
