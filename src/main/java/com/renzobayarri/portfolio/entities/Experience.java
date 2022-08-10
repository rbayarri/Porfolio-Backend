package com.renzobayarri.portfolio.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Experience {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String institution;
  private String charge;
  private LocalDate start_date;
  private LocalDate finish_date;
  private String description;

  public Experience() {
  }

  public Experience(int id, String institution, String charge, LocalDate start_date, LocalDate finish_date, String description) {
    this.id = id;
    this.institution = institution;
    this.charge = charge;
    this.start_date = start_date;
    this.finish_date = finish_date;
    this.description = description;
  }
  
}
