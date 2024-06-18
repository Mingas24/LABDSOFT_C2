package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.InputSampleDTO;
import com.pt.isep.labdsoft.dto.ui.UIPatientsFormDataDTO;
import com.pt.isep.labdsoft.dto.ui.UISamplesFormDataDTO;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import com.pt.isep.labdsoft.util.converter.SampleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Transactional
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private DonorSampleRepository donorSampleRepository;

    @Autowired
    private RecipientSampleRepository recipientSampleRepository;

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;

    @Autowired
    private TransplantDonorRepository transplantDonorRepository;

    @Autowired
    private SampleConverter sampleConverter;

    @Override
    public ResponseDTO registerSample(InputSampleDTO inputSampleDTO) {
        try {
            if (this.donorSampleRepository.findBySampleIdentification(inputSampleDTO.getSampleIdentification()).isPresent()) {
                return new ResponseDTO(false, "Donor sample identification is already registered.", StatusCode.ALREADY_EXISTS.getValue());
            }

            if (this.recipientSampleRepository.findBySampleIdentification(inputSampleDTO.getSampleIdentification()).isPresent()) {
                return new ResponseDTO(false, "Recipient sample identification is already registered.", StatusCode.ALREADY_EXISTS.getValue());
            }

            if (inputSampleDTO.getIsRecipient().equals("Recipient")) {

                Optional<TransplantRecipient> transplantRecipientOptional = this.transplantRecipientRepository.findByFullName(inputSampleDTO.getPatientIdentification());
                if (transplantRecipientOptional.isEmpty()) {
                    return new ResponseDTO(false, "Recipient not registered.", StatusCode.NOT_FOUND.getValue());
                }
                RecipientSample recipientSample = (RecipientSample) this.sampleConverter.toEntity(inputSampleDTO);
                recipientSample.setRecipient(transplantRecipientOptional.get());
                this.recipientSampleRepository.save(recipientSample);

            } else {

                Optional<TransplantDonor> donorOptional = this.transplantDonorRepository.findByFullName(inputSampleDTO.getPatientIdentification());
                if (donorOptional.isEmpty()) {
                    return new ResponseDTO(false, "Donor not registered.", StatusCode.NOT_FOUND.getValue());
                }
                DonorSample donorSample = (DonorSample) this.sampleConverter.toEntity(inputSampleDTO);
                donorSample.setDonor(donorOptional.get());
                this.donorSampleRepository.save(donorSample);
            }
            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }

    @Override
    public ResponseDTO getSamples() {
        List<String> donorSamples = this.donorSampleRepository.findAll().stream().map(DonorSample::getSampleIdentification).toList();
        List<String> recipientSamples = this.recipientSampleRepository.findAll().stream().map(RecipientSample::getSampleIdentification).toList();
        return new ResponseDTO(true, UISamplesFormDataDTO.builder().samples(Stream.concat(donorSamples.stream(), recipientSamples.stream()).toList()).build(),StatusCode.OK.getValue());

    }

}
