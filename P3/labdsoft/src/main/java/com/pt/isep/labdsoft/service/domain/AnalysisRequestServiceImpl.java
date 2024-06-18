package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisRequestDTO;
import com.pt.isep.labdsoft.dto.domain.AnalysisResultsDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import com.pt.isep.labdsoft.service.externalAPI.AnalysisResults.AnalysisResultsExternalAPIService;
import com.pt.isep.labdsoft.util.converter.AnalysisRequestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AnalysisRequestServiceImpl implements AnalysisRequestService {

    @Autowired
    private RecipientAnalysisRequestRepository recipientAnalysisRequestRepository;
    @Autowired
    private DonorAnalysisRequestRepository donorAnalysisRequestRepository;
    @Autowired
    private AnalysisTypeRepository analysisTypeRepository;
    @Autowired
    private AnalysisTypeRecipientRepository analysisTypeRecipientRepository;
    @Autowired
    private AnalysisTypeDonorRepository analysisTypeDonorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;
    @Autowired
    private TransplantDonorRepository transplantDonorRepository;
    @Autowired
    private RecipientSampleRepository recipientSampleRepository;
    @Autowired
    private DonorSampleRepository donorSampleRepository;
    @Autowired
    private AnalysisRequestConverter analysisRequestConverter;
    @Autowired
    private AnalysisResultsExternalAPIService analysisResultsExternalAPIService;
    @Autowired
    private BloodAnalysisResultService bloodAnalysisResultService;

    @Override
    public ResponseDTO registerAnalysisRequest(AnalysisRequestDTO analysisRequestDTO) {
        try {
            Optional<User> requestedByOptional = this.userRepository.findByUsername(analysisRequestDTO.getRequestedBy());
            if (requestedByOptional.isEmpty()) {
                return new ResponseDTO(false, "User not found", StatusCode.NOT_FOUND.getValue());
            }

            List<AnalysisType> analysisTypes = this.analysisTypeRepository.findAnalysisTypesByListOfDescriptions(analysisRequestDTO.getAnalysisTypes());

            if (analysisRequestDTO.getIsRecipient().equals("Recipient")) {
                Optional<TransplantRecipient> transplantRecipientOptional = this.transplantRecipientRepository.findByFullName(analysisRequestDTO.getPatientIdentification());
                if (transplantRecipientOptional.isEmpty()) {
                    return new ResponseDTO(false, "Recipient not found", StatusCode.NOT_FOUND.getValue());
                }
                Optional<RecipientSample> recipientSampleOptional = this.recipientSampleRepository.findBySampleIdentification(analysisRequestDTO.getSampleIdentification());
                if (recipientSampleOptional.isEmpty()) {
                    return new ResponseDTO(false, "Recipient sample not found", StatusCode.NOT_FOUND.getValue());
                }
                RecipientAnalysisRequest recipientAnalysisRequest = this.analysisRequestConverter.toEntityRecipient(requestedByOptional.get(), recipientSampleOptional.get(), transplantRecipientOptional.get());

                this.recipientAnalysisRequestRepository.save(recipientAnalysisRequest);
                this.analysisTypeRecipientRepository.saveAll(analysisTypes.stream().map(atr -> new AnalysisTypeRecipient(recipientAnalysisRequest, atr)).toList());
                AnalysisResultsDTO analysisResultsDTO = analysisResultsExternalAPIService.getAnalysisResults(analysisRequestDTO);
                this.bloodAnalysisResultService.registerRecipientBloodAnalysisResult(analysisResultsDTO, recipientAnalysisRequest);

            } else {
                Optional<TransplantDonor> transplantDonorOptional = this.transplantDonorRepository.findByFullName(analysisRequestDTO.getPatientIdentification());
                if (transplantDonorOptional.isEmpty()) {
                    return new ResponseDTO(false, "Donor not found", StatusCode.NOT_FOUND.getValue());
                }
                Optional<DonorSample> donorSampleOptional = this.donorSampleRepository.findBySampleIdentification(analysisRequestDTO.getSampleIdentification());
                if (donorSampleOptional.isEmpty()) {
                    return new ResponseDTO(false, "Donor sample not found", StatusCode.NOT_FOUND.getValue());
                }
                DonorAnalysisRequest donorAnalysisRequest = this.analysisRequestConverter.toEntityDonor(requestedByOptional.get(), donorSampleOptional.get(), transplantDonorOptional.get());

                this.donorAnalysisRequestRepository.save(donorAnalysisRequest);
                this.analysisTypeDonorRepository.saveAll(analysisTypes.stream().map(atd -> new AnalysisTypeDonor(donorAnalysisRequest, atd)).toList());
                AnalysisResultsDTO analysisResultsDTO = analysisResultsExternalAPIService.getAnalysisResults(analysisRequestDTO);
                this.bloodAnalysisResultService.registerDonorBloodAnalysisResult(analysisResultsDTO, donorAnalysisRequest);
            }

            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }
}
