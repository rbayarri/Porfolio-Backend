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
  @NotBlank(message="Certificate's name cannot be blank")
  @Size(min = 2, message="Certificate's name must contain at least 2 caracters")
  private String name;
  private String idValidation;
  @NotBlank(message="Certificate's institution cannot be blank")
  @Size(min = 4, message="Certificate's institution must contain at least 4 caracters")
  private String institution;
  @NotBlank(message="Certificate's date cannot be blank")
  @PastOrPresent(message="Certificate's date must be a past date")
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
