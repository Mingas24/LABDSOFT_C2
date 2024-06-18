package com.pt.isep.labdsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt.isep.labdsoft.entity.domain.BloodAnalysis;

public interface BloodAnalysisRepository extends JpaRepository<BloodAnalysis,Long> {
    
}
