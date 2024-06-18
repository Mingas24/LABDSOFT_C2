package com.pt.isep.labdsoft.service.ui;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.ui.*;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UILoaderServiceImpl implements UILoaderService {

    @Autowired
    private OrganTypeRepository organTypeRepository;
    @Autowired
    private BloodTypeRepository bloodTypeRepository;
    @Autowired
    private StateOfUrgencyRepository stateOfUrgencyRepository;
    @Autowired
    private HLATypeRepository hlaTypeRepository;
    @Autowired
    private TransplantDonorRepository transplantDonorRepository;
    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;
    @Autowired
    private AnalysisTypeRepository analysisTypeRepository;
    @Autowired
    private DonorBloodAnalysisResultRepository donorBloodAnalysisResultRepository;
    @Autowired
    private RecipientBloodAnalysisResultRepository recipientBloodAnalysisResultRepository;

    public ResponseDTO getTransplantRecipientFormData() {
        List<String> organTypes = this.organTypeRepository.findAll().stream().map(OrganType::getDescription).toList();

        List<String> bloodTypes = this.bloodTypeRepository.findAll().stream().map(BloodType::getDescription).toList();

        List<String> statesOfUrgency = this.stateOfUrgencyRepository.findAll().stream().map(StateOfUrgency::getDescription).toList();

        List<String> hlaTypes = this.hlaTypeRepository.findAll().stream().map(HLAType::getDescription).toList();

        return new ResponseDTO(true,
                UITransplantRecipientFormDataDTO.builder()
                        .organTypes(organTypes)
                        .statesOfUrgency(statesOfUrgency)
                        .bloodTypes(bloodTypes)
                        .hlaTypes(hlaTypes)
                        .build(),
                StatusCode.OK.getValue());
    }

    public ResponseDTO getTransplantDonorFormData() {
        List<String> organTypes = this.organTypeRepository.findAll().stream().map(OrganType::getDescription).toList();

        List<String> bloodTypes = this.bloodTypeRepository.findAll().stream().map(BloodType::getDescription).toList();

        List<String> hlaTypes = this.hlaTypeRepository.findAll().stream().map(HLAType::getDescription).toList();

        return new ResponseDTO(true, UITransplantDonorFormDataDTO.builder().
                organTypes(organTypes)
                .bloodTypes(bloodTypes)
                .hlaTypes(hlaTypes).build(), StatusCode.OK.getValue());
    }

    public ResponseDTO getAdherentFormData() {
        List<String> optionsList = new ArrayList<>();
        optionsList.add("Sim");
        optionsList.add("Não");

        return new ResponseDTO(true, UIAdherentFormDataDTO.builder().
                options(optionsList).build(), StatusCode.OK.getValue());
    }

    public ResponseDTO getOrganWastageFormData() {
        List<String> organTypes = this.organTypeRepository.findAll().stream().map(OrganType::getDescription).toList();
        return new ResponseDTO(true, UIOrganWastageFormDataDTO.builder().organTypes(organTypes).build(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getPatientsFormData() {
        List<String> donorPatients = this.transplantDonorRepository.findAll().stream().map(TransplantDonor::getFullName).toList();
        List<String> recipientPatients = this.transplantRecipientRepository.findAll().stream().map(TransplantRecipient::getFullName).toList();
        return new ResponseDTO(true, UIPatientsFormDataDTO.builder().patients(Stream.concat(donorPatients.stream(), recipientPatients.stream()).toList()).build(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getAnalysisRequestFormData() {
        List<String> analysesTypes = this.analysisTypeRepository.findAll().stream().map(AnalysisType::getDescription).toList();
        return new ResponseDTO(true, UIAnalysisRequestFormDataDTO.builder().analysisPossibilities(analysesTypes).build(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getChangeStateOfUrgencyFormData() {
        List<String> fullNameList = this.transplantRecipientRepository.findAll().stream().map(TransplantRecipient::getFullName).toList();
        List<String> statesOfUrgency = this.stateOfUrgencyRepository.findAll().stream().map(StateOfUrgency::getDescription).toList();
        return new ResponseDTO(true,
                UITransplantRecipientEditFormDataDTO.builder()
                        .fullName(fullNameList)
                        .statesOfUrgency(statesOfUrgency)
                        .build(),
                StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getAppointmentFormData() {
        List<String> fullNameList = this.transplantRecipientRepository.findAll().stream().map(TransplantRecipient::getFullName).toList();
        return new ResponseDTO(true,
                UiAppointmentFormDataDTO.builder()
                        .fullName(fullNameList).build(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getHealthActivityTrackerAssociationFormData(){
        List<String> transplantRecipientIdentificationList = this.transplantRecipientRepository.findAll().stream().map(TransplantRecipient::getIdentification).toList();
        return new ResponseDTO(true,
                UIHealthActivityTrackerFormDataDTO.builder()
                        .transplantRecipientIdentification(transplantRecipientIdentificationList).build(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getAnalysisResultsFormData() {
        List<String> sampleIdentificationDonorList = this.donorBloodAnalysisResultRepository.findByValidation().stream().map(DonorBloodAnalysisResult::getDonorSample).map(DonorSample::getSampleIdentification).toList();
        List<String> sampleIdentificationRecipientList = this.recipientBloodAnalysisResultRepository.findByValidation().stream().map(RecipientBloodAnalysisResult::getRecipientSample).map(RecipientSample::getSampleIdentification).toList();
        return new ResponseDTO(true, UIAnalysisResultsFormDataDTO.builder().sampleIdentifications(Stream.concat(sampleIdentificationDonorList.stream(), sampleIdentificationRecipientList.stream()).toList()).build(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getTranplantedOrganFormData() {
        List<String> organTypes = this.organTypeRepository.findAll().stream().map(OrganType::getDescription).toList();
        return new ResponseDTO(true,UITransplantedOrganFormDataDTO.builder().transplantedOrgan(organTypes).build(), StatusCode.OK.getValue());
    }


}