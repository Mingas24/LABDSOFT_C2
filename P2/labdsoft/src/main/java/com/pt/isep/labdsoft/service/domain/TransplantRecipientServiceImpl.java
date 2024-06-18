package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientDTO;
import com.pt.isep.labdsoft.dto.domain.UpdateRecipientUrgencyStatusDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.TransplantRecipientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TransplantRecipientServiceImpl implements TransplantRecipientService {

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StateOfUrgencyRepository stateOfUrgencyRepository;
    @Autowired
    private BloodTypeRepository bloodTypeRepository;
    @Autowired
    private OrganTypeRepository organTypeRepository;
    @Autowired
    private HLATypeRepository hlaTypeRepository;
    @Autowired
    private OrgansInNeedRepository organsInNeedRepository;
    @Autowired
    private HLATransplantRecipientRepository hlaTransplantRecipientRepository;
    @Autowired
    private TransplantRecipientConverter transplantRecipientConverter;
    @Autowired
    private SharedService sharedService;

    public ResponseDTO createTransplantRecipient(TransplantRecipientDTO transplantRecipientDTO) {
        try {
            Optional<User> assistentDoctorOptional = this.userRepository.findByUsername(transplantRecipientDTO.getAssistentDoctor());
            if (assistentDoctorOptional.isEmpty()) {
                return new ResponseDTO(false, "User not found", StatusCode.NOT_FOUND.getValue());
            }

            Optional<User> registeredByOptional = this.userRepository.findByUsername(transplantRecipientDTO.getRegisteredBy());
            if (registeredByOptional.isEmpty()) {
                return new ResponseDTO(false, "User not found", StatusCode.NOT_FOUND.getValue());
            }

            Optional<StateOfUrgency> stateOfUrgencyOptional = this.stateOfUrgencyRepository.findStateOfUrgencyByDescription(transplantRecipientDTO.getStateOfUrgency());
            if (stateOfUrgencyOptional.isEmpty()) {
                return new ResponseDTO(false, "State of Urgency not found", StatusCode.NOT_FOUND.getValue());
            }

            Optional<BloodType> bloodTypeOptional = this.bloodTypeRepository.findBloodTypeByDescription(transplantRecipientDTO.getBloodType());
            if (bloodTypeOptional.isEmpty()) {
                return new ResponseDTO(false, "Blood type not found", StatusCode.NOT_FOUND.getValue());
            }

            List<OrganType> organTypes = this.organTypeRepository.findOrganTypesByListOfDescriptions(transplantRecipientDTO.getOrgansInNeed());
            List<HLAType> hlaTypes = this.hlaTypeRepository.findHLATypesByListOfDescriptions(transplantRecipientDTO.getHlaTypes());

            TransplantRecipient transplantRecipient = transplantRecipientConverter.toEntity(transplantRecipientDTO);
            transplantRecipient.setAssistentDoctor(assistentDoctorOptional.get());
            transplantRecipient.setRegisteredBy(registeredByOptional.get());
            transplantRecipient.setStateOfUrgency(stateOfUrgencyOptional.get());
            transplantRecipient.setBloodType(bloodTypeOptional.get());

            this.transplantRecipientRepository.save(transplantRecipient);

            this.organsInNeedRepository.saveAll(organTypes.stream().map(ot -> new OrgansInNeed(transplantRecipient, ot)).toList());
            this.hlaTransplantRecipientRepository.saveAll(hlaTypes.stream().map(hlat -> new HLATransplantRecipient(transplantRecipient, hlat)).toList());

        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }

        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    //TODO: return values as DTOs
    public ResponseDTO getTransplantRecipients() {
        return new ResponseDTO(true, this.transplantRecipientRepository.findAll(), StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO updateRecipientStatus(UpdateRecipientUrgencyStatusDTO updateRecipientUrgencyStatusDTO) {
        try{
           Optional<TransplantRecipient> transplantRecipientOptional = this.transplantRecipientRepository.findByFullName(updateRecipientUrgencyStatusDTO.getFullName());
            if (transplantRecipientOptional.isEmpty()) {
                return new ResponseDTO(false, "Transplant recipient not found", StatusCode.NOT_FOUND.getValue());
            }

            Optional<StateOfUrgency> stateOfUrgencyOptional = this.stateOfUrgencyRepository.findStateOfUrgencyByDescription(updateRecipientUrgencyStatusDTO.getStateOfUrgency());
            if(stateOfUrgencyOptional.isEmpty()) {
                return new ResponseDTO(false, "State of Urgency not found", StatusCode.NOT_FOUND.getValue());
            }

            int updated = this.transplantRecipientRepository.updateUrgencyStatus(updateRecipientUrgencyStatusDTO.getFullName(), stateOfUrgencyOptional.get().getId());
            if (updated == 0)
                throw new IllegalArgumentException("Urgency status update failed");

            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        } catch(Exception ex){
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }

    public Page<TransplantRecipient> findAllByText(String text, String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(TransplantDonorDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        if (text != null) {
            return transplantRecipientRepository.findAllByFullName(text, pageable);
        } else {
            return transplantRecipientRepository.findAll(pageable);
        }
    }

    @Override
    public Page<TransplantRecipient> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(TransplantDonorDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return transplantRecipientRepository.findAll(pageable);
    }

}
