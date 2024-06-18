package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.HealthTrackerSimulatorDTO;
import com.pt.isep.labdsoft.dto.domain.VitalsAppointmentDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.VitalSigns;
import com.pt.isep.labdsoft.entity.domain.VitalsAppointment;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.VitalsAppointmentRepository;
import com.pt.isep.labdsoft.repository.TransplantRecipientRepository;
import com.pt.isep.labdsoft.repository.UserRepository;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.VitalsAppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class VitalsAppointmentServiceImpl implements VitalsAppointmentService {

    @Autowired
    private VitalsAppointmentRepository vitalsAppointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;

    @Autowired
    private VitalsAppointmentConverter vitalsAppointmentConverter;

    @Autowired
    private SharedService sharedService;

    @Autowired
    private HealthActivityTrackerService healthActivityTrackerService;

    @Override
    public ResponseDTO createAppointment(VitalsAppointmentDTO vitalsAppointmentDTO) {
        try {
            Optional<TransplantRecipient> optionalTransplantRecipient = this.transplantRecipientRepository.findByFullName(vitalsAppointmentDTO.getFullName());
            if (!optionalTransplantRecipient.isPresent()) {
                return new ResponseDTO(false, "Transplant Recipient could not be found.", StatusCode.NOT_FOUND.getValue());
            }

            Optional<User> optionalUser = this.userRepository.findByUsername(vitalsAppointmentDTO.getRegisteredBy());
            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "Medic could not be found.", StatusCode.NOT_FOUND.getValue());
            }

            healthActivityTrackerService.healthTrackerSimulator(HealthTrackerSimulatorDTO.builder()
                    .healthTrackerIdentifier(vitalsAppointmentDTO.getHealthTrackerIdentifier())
                    .bloodPressure(vitalsAppointmentDTO.getBloodPressure())
                    .bodyTemperature(vitalsAppointmentDTO.getBodyTemperature())
                    .heartRate(vitalsAppointmentDTO.getHeartRate())
                    .currentUser(vitalsAppointmentDTO.getRegisteredBy())
                    .build());

            VitalsAppointment vitalsAppointment = VitalsAppointment.builder()
                    .vitalsAppointmentDescription(vitalsAppointmentDTO.getVitalsAppointmentDescription())
                    .medic(optionalUser.get())
                    .patient(optionalTransplantRecipient.get())
                    .build();

            this.vitalsAppointmentRepository.save(vitalsAppointment);
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    @Override
    public Page<VitalsAppointment> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(VitalsAppointmentDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return vitalsAppointmentRepository.findAll(pageable);
    }
}
