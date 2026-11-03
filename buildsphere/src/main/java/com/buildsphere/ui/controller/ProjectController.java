package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.Project;
import com.buildsphere.ui.service.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Show Projects page
    @GetMapping
    public String projects(Model model, HttpSession session) {

        String role = RoleAccess.getRole(session);

        // Login required
        if (role == null) {
            return "redirect:/";
        }

        // Only Admin and Owner can open the management page
        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("project", new Project());
        model.addAttribute("role", role);

        return "projects";
    }

    // Add Project: Admin only
    @PostMapping("/save")
    public String saveProject(
            @ModelAttribute Project project,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN")) {
            return RoleAccess.dashboardFor(role);
        }

        projectService.saveProject(project);

        return "redirect:/projects";
    }

    // Delete Project: Admin only
    @GetMapping("/delete/{id}")
    public String deleteProject(
            @PathVariable Long id,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN")) {
            return RoleAccess.dashboardFor(role);
        }

        projectService.deleteProject(id);

        return "redirect:/projects";
    }
}
