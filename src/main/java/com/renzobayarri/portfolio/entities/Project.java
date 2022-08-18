package com.renzobayarri.portfolio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Project implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  @NotBlank
  private String name;
  @NotBlank
  private String description;
  private byte[] picture;
  private String urlGithub;
  private String urlProject;
  @ManyToMany
  private List<Technology> technologies = new ArrayList<>();

  public Project() {
  }

  public Project(int id, String name, String description, byte[] picture, String urlGithub, String urlProject) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.picture = picture;
    this.urlGithub = urlGithub;
    this.urlProject = urlProject;
  }

}
