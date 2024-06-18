package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.HealthActivityTrackerDTO;
import com.pt.isep.labdsoft.dto.domain.HealthTrackerRegistrationDTO;
import com.pt.isep.labdsoft.dto.domain.HealthTrackerSimulatorDTO;
import com.pt.isep.labdsoft.dto.domain.VitalSignsPageDTO;

public interface HealthActivityTrackerService {

    ResponseDTO registerHeathTracker(HealthTrackerRegistrationDTO healthTrackerRegistrationDTO);
    ResponseDTO associateHealthActivityTracker(HealthActivityTrackerDTO healthActivityTrackerDTO);
    ResponseDTO healthTrackerSimulator(HealthTrackerSimulatorDTO healthTrackerSimulatorDTO) throws Exception;
    PageDTO<VitalSignsPageDTO> getHealthTrackerActivityStatus(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize);
}
