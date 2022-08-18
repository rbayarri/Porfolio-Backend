package com.renzobayarri.portfolio.services;

import com.renzobayarri.portfolio.entities.Project;
import com.renzobayarri.portfolio.exceptions.ProjectNotFoundException;
import com.renzobayarri.portfolio.repositories.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {

  @Autowired
  ProjectRepository projectRepositoy;

  @Transactional
  public Project createProject(Project project) {
    return projectRepositoy.save(project);
  }

  @Transactional
  public Project updateProject(int id, Project project) throws ProjectNotFoundException {
    if (projectRepositoy.existsById(id)) {
      project.setId(id);
      return projectRepositoy.save(project);
    }
    throw new ProjectNotFoundException();
  }

  @Transactional
  public void deleteProject(int id) throws ProjectNotFoundException {
    if (projectRepositoy.existsById(id)) {
      projectRepositoy.deleteById(id);
      return;
    }
    throw new ProjectNotFoundException();
  }

  @Transactional(readOnly = true)
  public Project findProjectById(int id) throws ProjectNotFoundException {
    return projectRepositoy.findById(id)
            .orElseThrow(ProjectNotFoundException::new);
  }

  @Transactional(readOnly = true)
  public List<Project> listAllProjects() {
    return projectRepositoy.findAll();
  }
}
