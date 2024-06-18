package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisResultsDTO;
import com.pt.isep.labdsoft.entity.domain.DonorAnalysisRequest;
import com.pt.isep.labdsoft.entity.domain.RecipientAnalysisRequest;

public interface BloodAnalysisResultService {

    ResponseDTO registerDonorBloodAnalysisResult(AnalysisResultsDTO AnalysisResultsDTO, DonorAnalysisRequest donorAnalysisRequest);

    ResponseDTO registerRecipientBloodAnalysisResult(AnalysisResultsDTO AnalysisResultsDTO, RecipientAnalysisRequest recipientAnalysisRequest);

    ResponseDTO validateAnalysisResults(String sampleIdentification);
}
