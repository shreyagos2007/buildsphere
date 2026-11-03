package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.Equipment;
import com.buildsphere.ui.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public String equipment(Model model) {
        model.addAttribute("equipmentList", equipmentService.getAllEquipment());
        model.addAttribute("equipment", new Equipment());
        return "equipment";
    }

    @PostMapping("/save")
    public String saveEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipment";
    }

    @GetMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "redirect:/equipment";
    }
}