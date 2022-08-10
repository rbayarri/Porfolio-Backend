package com.renzobayarri.portfolio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Technology {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String name;

  public Technology() {
  }

  public Technology(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
}
