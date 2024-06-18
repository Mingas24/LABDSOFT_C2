package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.AnalysisType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnalysisTypeRepository  extends JpaRepository<AnalysisType, Integer> {

    @Query(value = "select at from AnalysisType at where at.description in :descriptions")
    List<AnalysisType> findAnalysisTypesByListOfDescriptions(List<String> descriptions);
}
