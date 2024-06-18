package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.*;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import com.pt.isep.labdsoft.service.externalAPI.HealthTracker.HealthTrackerExternalAPIService;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.VitalSignsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HealthActivityTrackerServiceImpl implements HealthActivityTrackerService {

    @Autowired
    private HealthActivityTrackerRepository healthActivityTrackerRepository;

    @Autowired
    private HealthActivityTrackerAssociationRepository healthActivityTrackerAssociationRepository;

    @Autowired
    private TransplantRecipientRepository transplantRecipientRepository;

    @Autowired
    private ProtocolRepository protocolRepository;

    @Autowired
    private VitalSignsRepository vitalSignsRepository;

    @Autowired
    private HealthTrackerExternalAPIService healthTrackerExternalAPIService;

    @Autowired
    private SharedService sharedService;

    @Autowired
    private VitalSignsConverter vitalSignsConverter;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public ResponseDTO registerHeathTracker(HealthTrackerRegistrationDTO healthTrackerRegistrationDTO) {
        Optional<HealthActivityTracker> healthActivityTrackerOptional = this.healthActivityTrackerRepository
                .findHealthActivityTrackerByHealthActivityTrackerId(Long.parseLong(healthTrackerRegistrationDTO.getHealthTrackerIdentifier()));
        if(healthActivityTrackerOptional.isPresent()){
            return new ResponseDTO(false, "Health Tracker already exists", StatusCode.ALREADY_EXISTS.getValue());
        }

        HealthActivityTracker healthActivityTracker = HealthActivityTracker.builder().healthActivityTrackerId(Long.parseLong(healthTrackerRegistrationDTO.getHealthTrackerIdentifier())).build();

        this.healthActivityTrackerRepository.save(healthActivityTracker);
        return new ResponseDTO(true, "Health Activity Tracker created correctly", StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO associateHealthActivityTracker(HealthActivityTrackerDTO healthActivityTrackerDTO) {
        HealthActivityTracker healthActivityTracker;
        Optional<HealthActivityTracker> healthActivityTrackerOptional = this.healthActivityTrackerRepository
                .findHealthActivityTrackerByHealthActivityTrackerId(healthActivityTrackerDTO.getHealthActivityTrackerId());

        if (healthActivityTrackerOptional.isEmpty()) {
            healthActivityTracker = this.healthActivityTrackerRepository.save(new HealthActivityTracker(healthActivityTrackerDTO.getHealthActivityTrackerId()));
        } else {
            healthActivityTracker = healthActivityTrackerOptional.get();
        }

        Optional<TransplantRecipient> transplantRecipientOptional = this.transplantRecipientRepository
                .findTransplantRecipientByIdentification(healthActivityTrackerDTO.getTransplantRecipientIdentification());
        if (transplantRecipientOptional.isEmpty()) {
            return new ResponseDTO(false, "Transplant recipient not found", StatusCode.NOT_FOUND.getValue());
        }

        Optional<Protocol> protocolOptional = this.protocolRepository.findProtocolByProtocol(healthActivityTrackerDTO.getProtocol());
        if (protocolOptional.isEmpty()) {
            return new ResponseDTO(false, "Protocol not found", StatusCode.NOT_FOUND.getValue());
        }
        List<HealthActivityTrackerAssociation> hatAssociationList =
                this.healthActivityTrackerAssociationRepository
                        .findHealthActivityTrackerAssociationsByTransplantRecipientOrHealthActivityTracker(transplantRecipientOptional.get(), healthActivityTracker);

        if (hatAssociationList.isEmpty()) {
            HealthActivityTrackerAssociation healthActivityTrackerAssociation = HealthActivityTrackerAssociation.builder()
                    .healthActivityTracker(healthActivityTracker)
                    .transplantRecipient(transplantRecipientOptional.get())
                    .protocol(protocolOptional.get().getProtocol())
                    .build();

            this.healthActivityTrackerAssociationRepository.save(healthActivityTrackerAssociation);

        } else if (hatAssociationList.size() == 1 && hatAssociationList.get(0).getTransplantRecipient().equals(transplantRecipientOptional.get())) {
            hatAssociationList.get(0).setHealthActivityTracker(healthActivityTracker);
            hatAssociationList.get(0).setTransplantRecipient(transplantRecipientOptional.get());
            hatAssociationList.get(0).setProtocol(protocolOptional.get().getProtocol());
            this.healthActivityTrackerAssociationRepository.save(hatAssociationList.get(0));
        } else {
            return new ResponseDTO(false, "Health activity tracker is already associated to another transplant recipient or vice versa", StatusCode.OPERATION_EXCEPTION.getValue());
        }

        return new ResponseDTO(true, "Health Activity Tracker associated correctly", StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO healthTrackerSimulator(HealthTrackerSimulatorDTO healthTrackerSimulatorDTO) throws Exception {
        Optional<HealthActivityTracker> healthActivityTrackerOptional = this.healthActivityTrackerRepository
                .findHealthActivityTrackerByHealthActivityTrackerId(Long.parseLong(healthTrackerSimulatorDTO.getHealthTrackerIdentifier()));
        if(healthActivityTrackerOptional.isEmpty()){
            return new ResponseDTO(false, "Device not found", StatusCode.NOT_FOUND.getValue());
        }

        List<HealthActivityTrackerAssociation> healthActivityTrackerAssociation = this.healthActivityTrackerAssociationRepository.findHealthActivityTrackerAssociationsByHealthActivityTracker(healthActivityTrackerOptional.get());
        Optional<Protocol> protocolOptional = this.protocolRepository.findProtocolByProtocol(healthActivityTrackerAssociation.get(0).getProtocol());
        if (protocolOptional.isEmpty()) {
            return new ResponseDTO(false, "Protocol not found", StatusCode.NOT_FOUND.getValue());
        }

        VitalSignsDTO vitalSignsDTO = VitalSignsDTO.builder().healthTrackerIdentifier(healthTrackerSimulatorDTO.getHealthTrackerIdentifier())
                .bloodPressure(healthTrackerSimulatorDTO.getBloodPressure())
                .bloodPressureProtocol(protocolOptional.get().getBloodPressure())
                .bodyTemperature(healthTrackerSimulatorDTO.getBodyTemperature())
                .bodyTemperatureProtocol(protocolOptional.get().getBodyTemperature())
                .heartRate(healthTrackerSimulatorDTO.getHeartRate())
                .heartRateProtocol(protocolOptional.get().getHeartRate())
                .build();

        HealthTrackerResultDTO healthTrackerResultDTO = this.healthTrackerExternalAPIService.getHealthTrackerActivityStatus(vitalSignsDTO);

        String stability;
        if(healthTrackerResultDTO.getHealthStatus().equals("")){
            stability = "Stable";
        } else {
            stability = "Not stable. Already notified!";
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(sender);
            mailMessage.setText("Dear " + healthTrackerSimulatorDTO.getCurrentUser() + ",\nThe device " + healthActivityTrackerAssociation.get(0).getHealthActivityTracker().getHealthActivityTrackerId() + " associated to " + healthActivityTrackerAssociation.get(0).getTransplantRecipient().getFullName() + " has " + healthTrackerResultDTO.getHealthStatus());
            mailMessage.setSubject("Health Tracker WARNING");
            // Sending the mail
            mailSender.send(mailMessage);
        }

        VitalSigns vitalSigns = VitalSigns.builder().healthTrackerIdentifier(healthTrackerSimulatorDTO.getHealthTrackerIdentifier())
                .bloodPressure(healthTrackerSimulatorDTO.getBloodPressure())
                .bodyTemperature(healthTrackerSimulatorDTO.getBodyTemperature())
                .heartRate(healthTrackerSimulatorDTO.getHeartRate())
                .stability(stability)
                .build();

        this.vitalSignsRepository.save(vitalSigns);
        return new ResponseDTO(true, "Simulation complete",StatusCode.OK.getValue());
    }

    @Override
    public PageDTO<VitalSignsPageDTO> getHealthTrackerActivityStatus(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(VitalSignsPageDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return vitalSignsConverter.toPageDTO(this.vitalSignsRepository.findAll(pageable));
    }
}
