package com.buildsphere.ui.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EntityManager entityManager;

    public DashboardController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        // Get logged-in user's role
        String role = (String) session.getAttribute("role");

        // If user is not logged in
        if (role == null) {
            return "redirect:/";
        }

        /*
         * ROLE BASED DASHBOARD
         */

        // OWNER
        if (role.equalsIgnoreCase("OWNER")) {
            return "owner-dashboard";
        }

        // WORKER
        if (role.equalsIgnoreCase("WORKER")) {
            return "worker-dashboard";
        }

        // MATERIAL MANAGER
        if (role.equalsIgnoreCase("MATERIAL_MANAGER")) {
            return "material-dashboard";
        }

        // SITE ENGINEER
        if (role.equalsIgnoreCase("SITE_ENGINEER")) {
            return "site-engineer-dashboard";
        }

        // ACCOUNTANT
        if (role.equalsIgnoreCase("ACCOUNTANT")) {
            return "accountant-dashboard";
        }

        /*
         * ADMIN DASHBOARD
         * Existing 8-module dashboard code
         */

        Long activeProjects = count(
                "SELECT COUNT(*) FROM projects WHERE LOWER(status) = 'active'"
        );

        Long totalWorkers = count(
                "SELECT COUNT(*) FROM workers"
        );

        Long totalMaterials = count(
                "SELECT COUNT(*) FROM materials"
        );

        Long totalEquipment = count(
                "SELECT COUNT(*) FROM equipment"
        );

        Long totalAttendance = count(
                "SELECT COUNT(*) FROM attendance"
        );

        Long totalProgress = count(
                "SELECT COUNT(*) FROM daily_progress"
        );

        Long totalSafety = count(
                "SELECT COUNT(*) FROM safety_records"
        );

        Long totalReports = count(
                "SELECT COUNT(*) FROM reports"
        );

        model.addAttribute("activeProjects", activeProjects);
        model.addAttribute("totalWorkers", totalWorkers);
        model.addAttribute("totalMaterials", totalMaterials);
        model.addAttribute("totalEquipment", totalEquipment);
        model.addAttribute("totalAttendance", totalAttendance);
        model.addAttribute("totalProgress", totalProgress);
        model.addAttribute("totalSafety", totalSafety);
        model.addAttribute("totalReports", totalReports);

        // Logged-in username
        model.addAttribute(
                "username",
                session.getAttribute("username")
        );

        return "dashboard";
    }

    private Long count(String query) {
        return ((Number) entityManager
                .createNativeQuery(query)
                .getSingleResult())
                .longValue();
    }
}