package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.Worker;
import com.buildsphere.ui.service.WorkerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    // View Workers: Admin and Owner
    @GetMapping
    public String workers(Model model, HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        model.addAttribute("workers", workerService.getAllWorkers());
        model.addAttribute("worker", new Worker());
        model.addAttribute("role", role);

        return "workers";
    }

    // Add Worker: Admin only
    @PostMapping("/save")
    public String saveWorker(
            @ModelAttribute Worker worker,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN")) {
            return RoleAccess.dashboardFor(role);
        }

        workerService.saveWorker(worker);

        return "redirect:/workers";
    }

    // Delete Worker: Admin only
    @GetMapping("/delete/{id}")
    public String deleteWorker(
            @PathVariable Long id,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN")) {
            return RoleAccess.dashboardFor(role);
        }

        workerService.deleteWorker(id);

        return "redirect:/workers";
    }
}
