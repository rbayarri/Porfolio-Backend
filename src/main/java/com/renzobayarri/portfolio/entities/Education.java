package com.renzobayarri.portfolio.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Education implements Comparable<Education> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @NotNull
  @Size(min = 6)
  private String carrer;
  @NotNull
  @Size(min = 6)
  private String institution;
  @NotNull
  @PastOrPresent
  private LocalDate startDate;
  @PastOrPresent
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

  public int compareTo(Education other) {
    return this.startDate.compareTo(other.getStartDate());
  }
}
