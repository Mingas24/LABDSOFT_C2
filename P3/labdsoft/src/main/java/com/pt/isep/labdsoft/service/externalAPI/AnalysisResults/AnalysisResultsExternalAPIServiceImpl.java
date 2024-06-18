package com.pt.isep.labdsoft.service.externalAPI.AnalysisResults;

import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisResultsDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Transactional
@Service
public class AnalysisResultsExternalAPIServiceImpl implements AnalysisResultsExternalAPIService{

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    private static final String URL_EXTERNAL_API = "http://localhost:8081/analysis-request-equipments";

    public AnalysisResultsDTO getAnalysisResults(AnalysisRequestDTO analysisRequestDTO) throws Exception {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AnalysisRequestDTO> response = new HttpEntity<>(analysisRequestDTO,headers);
        return restTemplate.postForObject(URL_EXTERNAL_API, response, AnalysisResultsDTO.class);
    }
}
