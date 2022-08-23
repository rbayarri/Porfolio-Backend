package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.assemblers.CertificateAssembler;
import com.renzobayarri.portfolio.entities.Certificate;
import com.renzobayarri.portfolio.exceptions.CertificateNotFoundException;
import com.renzobayarri.portfolio.services.CertificateService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

  @Autowired
  private CertificateService certificateService;

  @Autowired
  private CertificateAssembler assembler;

  @GetMapping("")
  public CollectionModel<EntityModel<Certificate>> getAll() {

    List<EntityModel<Certificate>> certificates = certificateService.listAllCertificates().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(certificates,
        linkTo(methodOn(CertificateController.class).getAll()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<Certificate> getOne(@PathVariable int id) throws CertificateNotFoundException {
    return assembler.toModel(certificateService.findCertificateById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> createOne(@RequestBody @Valid Certificate certificate) {
    EntityModel<Certificate> entity = assembler.toModel(certificateService.createCertificate(certificate));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);

  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateOne(@RequestBody @Valid Certificate certificate, @PathVariable int id) throws CertificateNotFoundException {
    EntityModel<Certificate> entity = assembler.toModel(certificateService.updateCertificate(id, certificate));
    return ResponseEntity.created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteOne(@PathVariable int id) throws CertificateNotFoundException {
    certificateService.deleteCertificate(id);
    return ResponseEntity.noContent().build();
  }

}
