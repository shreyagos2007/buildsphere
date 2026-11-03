package com.buildsphere.ui.controller;

import jakarta.servlet.http.HttpSession;

public final class RoleAccess {

    private RoleAccess() {
        // Utility class
    }

    public static String getRole(HttpSession session) {
        Object role = session.getAttribute("role");
        return role == null ? null : role.toString();
    }

    public static boolean hasRole(HttpSession session, String... allowedRoles) {
        String role = getRole(session);

        if (role == null) {
            return false;
        }

        for (String allowedRole : allowedRoles) {
            if (allowedRole.equalsIgnoreCase(role)) {
                return true;
            }
        }

        return false;
    }

    public static String dashboardFor(String role) {
        if (role == null) {
            return "redirect:/";
        }

        if ("OWNER".equalsIgnoreCase(role)) {
            return "redirect:/dashboard";
        }

        if ("WORKER".equalsIgnoreCase(role)) {
            return "redirect:/dashboard";
        }

        return "redirect:/dashboard";
    }
}
