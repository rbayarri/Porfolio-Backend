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
public class Experience implements Comparable<Experience>, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @NotBlank
  @Size(min = 6)
  private String institution;
  @NotBlank
  @Size(min = 6)
  private String charge;
  @NotBlank
  @PastOrPresent
  private LocalDate startDate;
  private LocalDate finishDate;
  @NotBlank
  @Size(min = 10)
  private String description;

  public Experience() {
  }

  public Experience(String institution, String charge, LocalDate start_date, LocalDate finish_date, String description) {
    this.institution = institution;
    this.charge = charge;
    this.startDate = start_date;
    this.finishDate = finish_date;
    this.description = description;
  }

  public Experience(int id, String institution, String charge, LocalDate start_date, LocalDate finish_date, String description) {
    this.id = id;
    this.institution = institution;
    this.charge = charge;
    this.startDate = start_date;
    this.finishDate = finish_date;
    this.description = description;
  }

  @Override
  public int compareTo(Experience other) {
    return this.finishDate.compareTo(other.getFinishDate());
  }

}
