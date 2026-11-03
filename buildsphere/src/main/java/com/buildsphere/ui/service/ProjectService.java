package com.buildsphere.ui.service;

import com.buildsphere.ui.model.Project;
import com.buildsphere.ui.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Add project
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get project by ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Update project
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    // Delete project
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}