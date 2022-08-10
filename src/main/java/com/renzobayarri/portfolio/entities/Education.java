
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
public class Education {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String carrer;
  private String institution;
  private LocalDate start_date;
  private LocalDate finish_date;

  public Education() {
  }

  public Education(int id, String carrer, String institution, LocalDate start_date, LocalDate finish_date) {
    this.id = id;
    this.carrer = carrer;
    this.institution = institution;
    this.start_date = start_date;
    this.finish_date = finish_date;
  }
  
  
  
}
