package com.buildsphere.ui.service;

import com.buildsphere.ui.model.Safety;
import com.buildsphere.ui.repository.SafetyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SafetyService {

    private final SafetyRepository safetyRepository;

    public SafetyService(SafetyRepository safetyRepository) {
        this.safetyRepository = safetyRepository;
    }

    public Safety saveSafety(Safety safety) {
        return safetyRepository.save(safety);
    }

    public List<Safety> getAllSafety() {
        return safetyRepository.findAll();
    }

    public Optional<Safety> getSafetyById(Long id) {
        return safetyRepository.findById(id);
    }

    public Safety updateSafety(Safety safety) {
        return safetyRepository.save(safety);
    }

    public void deleteSafety(Long id) {
        safetyRepository.deleteById(id);
    }
}