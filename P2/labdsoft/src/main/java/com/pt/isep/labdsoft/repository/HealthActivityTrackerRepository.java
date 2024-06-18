package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.HealthActivityTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthActivityTrackerRepository extends JpaRepository<HealthActivityTracker, Long> {

    Optional<HealthActivityTracker> findHealthActivityTrackerByHealthActivityTrackerId(Long healthActivityTrackerId);
}
