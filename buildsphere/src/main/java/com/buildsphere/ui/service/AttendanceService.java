package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.Attendance;
import com.buildsphere.ui.service.AttendanceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/attendance")
 public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public String attendance(Model model, HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        model.addAttribute("attendanceList", attendanceService.getAllAttendance());
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("role", role);

        return "attendance";
    }

    // Add or Update Attendance
    @PostMapping("/save")
    public String saveAttendance(
            @ModelAttribute Attendance attendance,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        attendanceService.saveAttendance(attendance);

        return "redirect:/attendance";
    }

    // Open Edit Form
    @GetMapping("/edit/{id}")
    public String editAttendance(
            @PathVariable Long id,
            Model model,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        Attendance attendance = attendanceService.getAttendanceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid attendance ID"));

        model.addAttribute("attendance", attendance);
        model.addAttribute("attendanceList", attendanceService.getAllAttendance());
        model.addAttribute("role", role);

        return "attendance";
    }

    // Delete Attendance
    @GetMapping("/delete/{id}")
    public String deleteAttendance(
            @PathVariable Long id,
            HttpSession session) {

        String role = RoleAccess.getRole(session);

        if (role == null) {
            return "redirect:/";
        }

        if (!RoleAccess.hasRole(session, "ADMIN", "OWNER")) {
            return RoleAccess.dashboardFor(role);
        }

        attendanceService.deleteAttendance(id);

        return "redirect:/attendance";
    }
}