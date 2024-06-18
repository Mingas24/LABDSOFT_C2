package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodTypeRepository extends JpaRepository<BloodType, Integer> {

    Optional<BloodType> findBloodTypeByDescription(String description);
}
