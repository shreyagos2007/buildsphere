package com.buildsphere.ui.repository;

import com.buildsphere.ui.model.DailyProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DailyProgressRepository extends JpaRepository<DailyProgress, Long> {
}