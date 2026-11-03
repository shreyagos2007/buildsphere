package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.DailyProgress;
import com.buildsphere.ui.service.DailyProgressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/progress")
public class DailyProgressController {

    private final DailyProgressService dailyProgressService;

    public DailyProgressController(DailyProgressService dailyProgressService) {
        this.dailyProgressService = dailyProgressService;
    }

    @GetMapping
    public String progress(Model model) {
        model.addAttribute("progressList", dailyProgressService.getAllProgress());
        model.addAttribute("progress", new DailyProgress());
        return "progress";
    }

    @PostMapping("/save")
    public String saveProgress(@ModelAttribute DailyProgress progress) {
        dailyProgressService.saveProgress(progress);
        return "redirect:/progress";
    }

    @GetMapping("/delete/{id}")
    public String deleteProgress(@PathVariable Long id) {
        dailyProgressService.deleteProgress(id);
        return "redirect:/progress";
    }
}