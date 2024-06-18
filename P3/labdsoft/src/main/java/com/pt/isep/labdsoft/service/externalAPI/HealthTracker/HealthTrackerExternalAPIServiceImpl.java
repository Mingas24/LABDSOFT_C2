package com.pt.isep.labdsoft.service.externalAPI.HealthTracker;

import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisResultsDTO;
import com.pt.isep.labdsoft.dto.domain.HealthTrackerResultDTO;
import com.pt.isep.labdsoft.dto.domain.VitalSignsDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Transactional
@Service
public class HealthTrackerExternalAPIServiceImpl implements HealthTrackerExternalAPIService {

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();

    private static final String URL_EXTERNAL_API = "http://localhost:8082/health-tracker";

    public AnalysisResultsDTO getAnalysisResults(AnalysisRequestDTO analysisRequestDTO) throws Exception {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AnalysisRequestDTO> x = new HttpEntity<>(analysisRequestDTO,headers);
        return restTemplate.postForObject(URL_EXTERNAL_API, x, AnalysisResultsDTO.class);
    }

    @Override
    public HealthTrackerResultDTO getHealthTrackerActivityStatus(VitalSignsDTO vitalSignsDTO) throws Exception {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<VitalSignsDTO> response = new HttpEntity<>(vitalSignsDTO, headers);
        return restTemplate.postForObject(URL_EXTERNAL_API, response, HealthTrackerResultDTO.class);
    }
}
