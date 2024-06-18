package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.DonorBloodAnalysisResult;
import com.pt.isep.labdsoft.entity.domain.DonorSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DonorBloodAnalysisResultRepository extends JpaRepository<DonorBloodAnalysisResult,Long> {

    @Query(value = "select dbar from DonorBloodAnalysisResult dbar where dbar.isValidated = false")
    List<DonorBloodAnalysisResult> findByValidation();
}
