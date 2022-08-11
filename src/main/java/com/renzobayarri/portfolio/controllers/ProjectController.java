package com.renzobayarri.portfolio.controllers;

import com.renzobayarri.portfolio.entities.Project;
import com.renzobayarri.portfolio.services.ProjectService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping("/")
  public List<Project> getAll() {
    return projectService.listAllProjects();
  }

  @GetMapping("/{id}")
  public Project getOne(@PathVariable int id) {
    return projectService.findProjectById(id);
  }

  @PostMapping("/")
  public Project createOne(@RequestBody @Valid Project project) {
    return projectService.createProject(project);
  }

  @PutMapping("/{id}")
  public Project updateOne(@RequestBody @Valid Project project, @PathVariable int id) {
    return projectService.updateProject(id, project);
  }

  @DeleteMapping("/{id}")
  public void deleteOne(@PathVariable int id) {
    projectService.deleteProject(id);
  }
}
