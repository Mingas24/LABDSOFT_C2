package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentManagementDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.AppointmentManagement;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.AppointmentManagementRepository;
import com.pt.isep.labdsoft.repository.TransplantRecipientRepository;
import com.pt.isep.labdsoft.repository.UserRepository;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.AppointmentManagementConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AppointmentManagementServiceImpl implements AppointmentManagementService {

    @Autowired
    private AppointmentManagementRepository appointmentManagementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;

    @Autowired
    private AppointmentManagementConverter appointmentManagementConverter;

    @Autowired
    private SharedService sharedService;

    @Override
    public ResponseDTO createAppointmentManagement(AppointmentManagementDTO appointmentManagementDTO) {
        try {
            Optional<TransplantRecipient> optionalTransplantRecipient = this.transplantRecipientRepository.findByIdentification(appointmentManagementDTO.getPatientId());
            if (!optionalTransplantRecipient.isPresent()) {
                return new ResponseDTO(false, "Transplant Recipient could not be found.", StatusCode.NOT_FOUND.getValue());
            }

            Optional<User> optionalUser = this.userRepository.findByUsername(appointmentManagementDTO.getMedic());
            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "Medic could not be found.", StatusCode.NOT_FOUND.getValue());
            }

            AppointmentManagement appointmentManagement = appointmentManagementConverter.toEntity(appointmentManagementDTO);
            appointmentManagement.setPatient(optionalTransplantRecipient.get());
            appointmentManagement.setMedic(optionalUser.get());

            this.appointmentManagementRepository.save(appointmentManagement);
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }

        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    @Override
    public ResponseDTO getAppointmentManagementsByPatientId(String identification){
        Optional<TransplantRecipient> optionalTransplantRecipient = this.transplantRecipientRepository.findByIdentification(identification);

        if (optionalTransplantRecipient.isEmpty()) {
            return new ResponseDTO(false, "Patient could not be found.", StatusCode.NOT_FOUND.getValue());
        }

        Optional<List<AppointmentManagement>> appointmentManagementsOptional = this.appointmentManagementRepository.findAllByPatientIdentification(identification);

        if(appointmentManagementsOptional.isEmpty()){
            return new ResponseDTO(false, "Patient has no appointments.", StatusCode.NOT_FOUND.getValue());
        }

        List<AppointmentManagementDTO> appointmentManagementDTOs = appointmentManagementsOptional.get().stream().map(res ->
                this.appointmentManagementConverter.toDTO(res)).toList();

        return new ResponseDTO(true, appointmentManagementDTOs, StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getAppointmentManagementByPatientIdAndApptDt(String identification, Date appointmentManagementDate){
        Optional<TransplantRecipient> optionalTransplantRecipient = this.transplantRecipientRepository.findByIdentification(identification);

        if (optionalTransplantRecipient.isEmpty()) {
            return new ResponseDTO(false, "Patient could not be found.", StatusCode.NOT_FOUND.getValue());
        }

        Optional<List<AppointmentManagement>> appointmentManagementsOptional = this.appointmentManagementRepository.findAllByPatientIdentificationAndAppointmentManagementDate(identification, appointmentManagementDate);

        if(appointmentManagementsOptional.isEmpty()){
            return new ResponseDTO(false, "Patient has no appointments for the date specified.", StatusCode.NOT_FOUND.getValue());
        }

        List<AppointmentManagementDTO> appointmentManagementDTOs = appointmentManagementsOptional.get().stream().map(res ->
                this.appointmentManagementConverter.toDTO(res)).toList();

        return new ResponseDTO(true, appointmentManagementDTOs, StatusCode.OK.getValue());
    }

    @Override
    public Page<AppointmentManagement> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(AppointmentManagementDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return appointmentManagementRepository.findAll(pageable);
    }
}
