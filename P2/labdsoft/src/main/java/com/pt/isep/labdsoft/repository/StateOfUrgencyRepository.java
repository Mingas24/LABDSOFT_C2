package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.StateOfUrgency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateOfUrgencyRepository extends JpaRepository<StateOfUrgency, Integer> {

    Optional<StateOfUrgency> findStateOfUrgencyByDescription(String description);
}
