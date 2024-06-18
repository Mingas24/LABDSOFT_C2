package com.pt.isep.labdsoft.service.externalAPI.AnalysisResults;

import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisResultsDTO;


public interface AnalysisResultsExternalAPIService {

    public AnalysisResultsDTO getAnalysisResults(AnalysisRequestDTO analysisRequestDTO) throws Exception;
}
