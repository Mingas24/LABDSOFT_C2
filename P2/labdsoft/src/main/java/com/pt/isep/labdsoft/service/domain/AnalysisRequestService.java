package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;

public interface AnalysisRequestService {

    ResponseDTO registerAnalysisRequest(AnalysisRequestDTO analysisRequestDTO);
}
