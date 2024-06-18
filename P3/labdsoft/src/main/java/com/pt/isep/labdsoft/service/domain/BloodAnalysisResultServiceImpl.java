package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisResultsDTO;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BloodAnalysisResultServiceImpl implements BloodAnalysisResultService {

    @Autowired
    private BloodAnalysisRepository bloodAnalysisRepository;
    @Autowired
    private BloodAnalysisDonorRepository bloodAnalysisDonorRepository;
    @Autowired
    private BloodAnalysisRecipientRepository bloodAnalysisRecipientRepository;
    @Autowired
    private RecipientBloodAnalysisResultRepository recipientBloodAnalysisResultRepository;
    @Autowired
    private DonorBloodAnalysisResultRepository donorBloodAnalysisResultRepository;

    public List<BloodAnalysis> registerBloodAnalysisResult(AnalysisResultsDTO analysisResultsDTO) {
        List<BloodAnalysis> bloodAnalysisList = new ArrayList<>();
        for (Map.Entry<String, List<Object>> entry : analysisResultsDTO.getAnalysisResults().entrySet()) {
            String value = String.valueOf(entry.getValue().get(0));
            String result = String.valueOf(entry.getValue().get(1));
            BloodAnalysis bloodAnalysis = BloodAnalysis.builder().bloodAnalysisMethod(entry.getKey()).analysisResultValue(value).analysisResult(result.equals("null") ? null : result).build();
            bloodAnalysisList.add(bloodAnalysis);
        }
        return bloodAnalysisList;
    }

    @Override
    public ResponseDTO registerDonorBloodAnalysisResult(AnalysisResultsDTO analysisResultsDTO, DonorAnalysisRequest donorAnalysisRequest) {
        try {
            List<BloodAnalysis> bloodAnalysisList = this.registerBloodAnalysisResult(analysisResultsDTO);
            DonorBloodAnalysisResult donorBloodAnalysisResult = DonorBloodAnalysisResult.builder().donor(donorAnalysisRequest.getTransplantDonor()).donorSample(donorAnalysisRequest.getDonorSample()).analysisDate(new Date()).isValidated(false).build();
            this.donorBloodAnalysisResultRepository.save(donorBloodAnalysisResult);
            this.bloodAnalysisRepository.saveAll(bloodAnalysisList);
            this.bloodAnalysisDonorRepository.saveAll(bloodAnalysisList.stream().map(bad -> new BloodAnalysisDonor(donorBloodAnalysisResult, bad)).toList());
            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }

    @Override
    public ResponseDTO registerRecipientBloodAnalysisResult(AnalysisResultsDTO analysisResultsDTO, RecipientAnalysisRequest recipientAnalysisRequest) {
        try {
            List<BloodAnalysis> bloodAnalysisList = this.registerBloodAnalysisResult(analysisResultsDTO);
            RecipientBloodAnalysisResult recipientBloodAnalysisResult = RecipientBloodAnalysisResult.builder().recipient(recipientAnalysisRequest.getTransplantRecipient()).recipientSample(recipientAnalysisRequest.getRecipientSample()).analysisDate(new Date()).isValidated(false).build();
            this.recipientBloodAnalysisResultRepository.save(recipientBloodAnalysisResult);
            this.bloodAnalysisRepository.saveAll(bloodAnalysisList);
            this.bloodAnalysisRecipientRepository.saveAll(bloodAnalysisList.stream().map(bad -> new BloodAnalysisRecipient(recipientBloodAnalysisResult, bad)).toList());
            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }

    @Override
    public ResponseDTO validateAnalysisResults(String sampleIdentification) {
        try {
            DonorBloodAnalysisResult donorBloodAnalysisResult = checkIfIsDonor(sampleIdentification);
            RecipientBloodAnalysisResult recipientBloodAnalysisResult = checkIfIsRecipient(sampleIdentification);
            if (donorBloodAnalysisResult != null) {
                donorBloodAnalysisResult.setValidated(true);
                this.donorBloodAnalysisResultRepository.save(donorBloodAnalysisResult);
            } else if (recipientBloodAnalysisResult != null) {
                recipientBloodAnalysisResult.setValidated(true);
                this.recipientBloodAnalysisResultRepository.save(recipientBloodAnalysisResult);
            } else {
                return new ResponseDTO(false, "Sample identification does not exist", StatusCode.NOT_FOUND.getValue());
            }
            return new ResponseDTO(true, "", StatusCode.UPDATED.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }


    private DonorBloodAnalysisResult checkIfIsDonor(String sampleIdentification) {
        List<DonorBloodAnalysisResult> donorSampleList = this.donorBloodAnalysisResultRepository.findByValidation();
        for (DonorBloodAnalysisResult donorBloodAnalysisResult : donorSampleList) {
            if (donorBloodAnalysisResult.getDonorSample().getSampleIdentification().equals(sampleIdentification)) {
                return donorBloodAnalysisResult;
            }
        }
        return null;
    }

    private RecipientBloodAnalysisResult checkIfIsRecipient(String sampleIdentification) {
        List<RecipientBloodAnalysisResult> donorSampleList = this.recipientBloodAnalysisResultRepository.findByValidation();
        for (RecipientBloodAnalysisResult recipientBloodAnalysisResult : donorSampleList) {
            if (recipientBloodAnalysisResult.getRecipientSample().getSampleIdentification().equals(sampleIdentification)) {
                return recipientBloodAnalysisResult;
            }
        }
        return null;
    }
}
