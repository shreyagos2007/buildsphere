package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.Material;
import com.buildsphere.ui.service.MaterialService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    // View Materials: Admin and Owner
    @GetMapping
    public String materials(Model model, HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        model.addAttribute("materials", materialService.getAllMaterials());
        model.addAttribute("material", new Material());
        model.addAttribute("role", role);

        return "materials";
    }

    // Add Material: Admin only
    @PostMapping("/save")
    public String saveMaterial(
            @ModelAttribute Material material,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN")) {
            return RoleAccess.dashboardFor(role);
        }

        materialService.saveMaterial(material);

        return "redirect:/materials";
    }

    // Delete Material: Admin only
    @GetMapping("/delete/{id}")
    public String deleteMaterial(
            @PathVariable Long id,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN")) {
            return RoleAccess.dashboardFor(role);
        }

        materialService.deleteMaterial(id);

        return "redirect:/materials";
    }
}
