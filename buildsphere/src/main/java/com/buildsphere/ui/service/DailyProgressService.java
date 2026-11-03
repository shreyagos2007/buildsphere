package com.buildsphere.ui.service;

import com.buildsphere.ui.model.DailyProgress;
import com.buildsphere.ui.repository.DailyProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyProgressService {

    private final DailyProgressRepository dailyProgressRepository;

    public DailyProgressService(DailyProgressRepository dailyProgressRepository) {
        this.dailyProgressRepository = dailyProgressRepository;
    }

    public DailyProgress saveProgress(DailyProgress progress) {
        return dailyProgressRepository.save(progress);
    }

    public List<DailyProgress> getAllProgress() {
        return dailyProgressRepository.findAll();
    }

    public Optional<DailyProgress> getProgressById(Long id) {
        return dailyProgressRepository.findById(id);
    }

    public DailyProgress updateProgress(DailyProgress progress) {
        return dailyProgressRepository.save(progress);
    }

    public void deleteProgress(Long id) {
        dailyProgressRepository.deleteById(id);
    }
}