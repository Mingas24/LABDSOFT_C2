package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.DonorSample;
import com.pt.isep.labdsoft.entity.domain.RecipientSample;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pt.isep.labdsoft.entity.domain.RecipientBloodAnalysisResult;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipientBloodAnalysisResultRepository extends JpaRepository<RecipientBloodAnalysisResult,Long> {
    @Query(value = "select rbar from RecipientBloodAnalysisResult rbar where rbar.isValidated = false")
    List<RecipientBloodAnalysisResult> findByValidation();
}
