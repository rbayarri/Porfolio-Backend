package com.renzobayarri.portfolio.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Certificate implements Comparable<Certificate>, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @NotBlank
  @Size(min = 2)
  private String name;
  private String idValidation;
  @NotBlank
  @Size(min = 4)
  private String institution;
  @NotBlank
  @PastOrPresent
  private LocalDate date;

  public Certificate() {
  }

  public Certificate(String name, String idValidation, String institution, LocalDate date) {
    this.name = name;
    this.idValidation = idValidation;
    this.institution = institution;
    this.date = date;
  }

  public Certificate(int id, String name, String idValidation, String institution, LocalDate date) {
    this.id = id;
    this.name = name;
    this.idValidation = idValidation;
    this.institution = institution;
    this.date = date;
  }

  @Override
  public int compareTo(Certificate other) {
    return this.date.compareTo(other.getDate());
  }
}
