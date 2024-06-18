package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.OrganType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganTypeRepository extends JpaRepository<OrganType, Integer> {

    @Query(value = "select ot from OrganType ot where ot.description in :descriptions")
    List<OrganType> findOrganTypesByListOfDescriptions(List<String> descriptions);

    Optional<OrganType> findOrganTypeByDescription(String description);
}
