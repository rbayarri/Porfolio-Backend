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
  @NotBlank(message="Experience's institution cannot be blank")
  @Size(min = 6, message="Experience's institution must contain at least 6 caracters")
  private String institution;
  @NotBlank(message="Experience's charge cannot be blank")
  @Size(min = 6, message="Experience's charge must contain at least 6 caracters")
  private String charge;
  @NotBlank(message="Experience's start date cannot be blank")
  @PastOrPresent(message="Experience's start date must be a past date")
  private LocalDate startDate;
  private LocalDate finishDate;
  @NotBlank(message="Experience's description cannot be blank")
  @Size(min = 10, message="Experience's description must contain at least 10 caracters")
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
