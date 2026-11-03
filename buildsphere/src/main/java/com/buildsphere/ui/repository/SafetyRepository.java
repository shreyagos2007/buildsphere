package com.buildsphere.ui.repository;

import com.buildsphere.ui.model.Safety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyRepository extends JpaRepository<Safety, Long> {
}
