package com.renzobayarri.portfolio.entities;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String name;
  private String description;
  private byte[] picture;
  private String url_github;
  private String url_project;
  @ManyToMany
  private ArrayList<Technology> technologies = new ArrayList<>();

  public Project() {
  }

  public Project(int id, String name, String description, byte[] picture, String url_github, String url_project) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.picture = picture;
    this.url_github = url_github;
    this.url_project = url_project;
  }

}
