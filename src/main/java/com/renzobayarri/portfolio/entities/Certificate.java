
package com.renzobayarri.portfolio.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Certificate {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String name;
  private String id_validation;
  private String institution;
  private LocalDate date;

  public Certificate() {
  }

  public Certificate(int id, String name, String id_validation, String institution, LocalDate date) {
    this.id = id;
    this.name = name;
    this.id_validation = id_validation;
    this.institution = institution;
    this.date = date;
  }
  
}
