package com.pt.isep.labdsoft.service.externalAPI.HealthTracker;

import com.pt.isep.labdsoft.dto.domain.HealthTrackerResultDTO;
import com.pt.isep.labdsoft.dto.domain.VitalSignsDTO;

public interface HealthTrackerExternalAPIService {

    public HealthTrackerResultDTO getHealthTrackerActivityStatus(VitalSignsDTO vitalSignsDTO) throws Exception;
}
