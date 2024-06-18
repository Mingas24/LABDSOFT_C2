package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.HealthActivityTrackerDTO;

public interface HealthActivityTrackerService {

    ResponseDTO associateHealthActivityTracker(HealthActivityTrackerDTO healthActivityTrackerDTO);
}
