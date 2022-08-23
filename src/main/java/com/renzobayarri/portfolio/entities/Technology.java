package com.renzobayarri.portfolio.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Technology implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @NotBlank(message="Technology's name cannot be blank")
  private String name;

  public Technology() {
  }

  public Technology(int id, String name) {
    this.id = id;
    this.name = name;
  }

}
