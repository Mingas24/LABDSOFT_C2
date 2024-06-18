package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.HLAType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HLATypeRepository extends JpaRepository<HLAType, Integer> {

    @Query(value = "select hlat from HLAType hlat where hlat.description in :descriptions")
    List<HLAType> findHLATypesByListOfDescriptions(List<String> descriptions);
}
