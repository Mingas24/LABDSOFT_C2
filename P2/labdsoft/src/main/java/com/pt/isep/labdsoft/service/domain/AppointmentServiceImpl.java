package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AppointmentDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.Appointment;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.AppointmentRepository;
import com.pt.isep.labdsoft.repository.TransplantRecipientRepository;
import com.pt.isep.labdsoft.repository.UserRepository;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.AppointmentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;

    @Autowired
    private AppointmentConverter appointmentConverter;

    @Autowired
    private SharedService sharedService;

    @Override
    public ResponseDTO createAppointment(AppointmentDTO appointmentDTO) {
        try {
            Optional<TransplantRecipient> optionalTransplantRecipient = this.transplantRecipientRepository.findByFullName(appointmentDTO.getFullName());
            if (!optionalTransplantRecipient.isPresent()) {
                return new ResponseDTO(false, "Transplant Recipient could not be found.", StatusCode.NOT_FOUND.getValue());
            }

            Optional<User> optionalUser = this.userRepository.findByUsername(appointmentDTO.getRegisteredBy());
            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "Medic could not be found.", StatusCode.NOT_FOUND.getValue());
            }

            Appointment appointment = appointmentConverter.toEntity(appointmentDTO);
            appointment.setPatient(optionalTransplantRecipient.get());
            appointment.setMedic(optionalUser.get());

            this.appointmentRepository.save(appointment);
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }

        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    @Override
    public Page<Appointment> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(AppointmentDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return appointmentRepository.findAll(pageable);
    }
}
