package com.renzobayarri.portfolio.assemblers;

import com.renzobayarri.portfolio.entities.Certificate;
import com.renzobayarri.portfolio.controllers.CertificateController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class CertificateAssembler implements RepresentationModelAssembler<Certificate, EntityModel<Certificate>> {

  @Override
  public EntityModel<Certificate> toModel(Certificate entity) {
    return EntityModel.of(entity, 
        linkTo(methodOn(CertificateController.class).getOne(entity.getId())).withSelfRel(),
        linkTo(methodOn(CertificateController.class).getAll()).withRel("certificates"));
  }

}
