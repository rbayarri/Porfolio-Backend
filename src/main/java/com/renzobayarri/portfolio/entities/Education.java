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
public class Education implements Comparable<Education>, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @NotBlank(message="Education's carrer cannot be blank")
  @Size(min = 6, message="Education's carrer must contain at least 6 caracters")
  private String carrer;
  @NotBlank(message="Education's institution cannot be blank")
  @Size(min = 6, message="Education's institution must contain at least 6 caracters")
  private String institution;
  @NotBlank(message="Education's start date cannot be blank")
  @PastOrPresent(message="Education's start date must be a past date")
  private LocalDate startDate;
  @PastOrPresent(message="Education's finishDate date must be a past date")
  private LocalDate finishDate;

  public Education() {
  }

  public Education(String carrer, String institution, LocalDate startDate, LocalDate finishDate) {
    this.carrer = carrer;
    this.institution = institution;
    this.startDate = startDate;
    this.finishDate = finishDate;
  }

  public Education(int id, String carrer, String institution, LocalDate startDate, LocalDate finishDate) {
    this.id = id;
    this.carrer = carrer;
    this.institution = institution;
    this.startDate = startDate;
    this.finishDate = finishDate;
  }

  @Override
  public int compareTo(Education other) {
    return this.startDate.compareTo(other.getStartDate());
  }
}
