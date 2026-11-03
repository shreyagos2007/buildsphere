package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.Safety;
import com.buildsphere.ui.service.SafetyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/safety")
public class SafetyController {

    private final SafetyService safetyService;

    public SafetyController(SafetyService safetyService) {
        this.safetyService = safetyService;
    }

    @GetMapping
    public String safety(Model model) {
        model.addAttribute("safetyList", safetyService.getAllSafety());
        model.addAttribute("safety", new Safety());
        return "safety";
    }

    @PostMapping("/save")
    public String saveSafety(@ModelAttribute Safety safety) {
        safetyService.saveSafety(safety);
        return "redirect:/safety";
    }

    @GetMapping("/delete/{id}")
    public String deleteSafety(@PathVariable Long id) {
        safetyService.deleteSafety(id);
        return "redirect:/safety";
    }
}