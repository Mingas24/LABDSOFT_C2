package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientListDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class TransplantRecipientConverter {

    public String dateFormat(Date dateToFormat){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(dateToFormat);
        return formattedDate;
    }

    public Date dateISO8601(String dateToFormat) throws ParseException {
        String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date dateToReturn = simpleDateFormat.parse(dateToFormat);
        return dateToReturn;
    }

    public TransplantRecipient toEntity(final TransplantRecipientDTO transplantRecipientDTO){
        return TransplantRecipient.builder()
                .registrationDate(transplantRecipientDTO.getRegistrationDate())
                .fullName(transplantRecipientDTO.getFullName())
                .address(transplantRecipientDTO.getAddress())
                .dateOfBirth(transplantRecipientDTO.getDateOfBirth())
                .identification(transplantRecipientDTO.getIdentification())
                .nationality(transplantRecipientDTO.getNationality())
                .imc(transplantRecipientDTO.getImc())
                .stateOfUrgencyDate(transplantRecipientDTO.getStateOfUrgencyDate() == null ? new Date() : transplantRecipientDTO.getStateOfUrgencyDate())
                .build();
    }

    public TransplantRecipientDTO toDTO(final TransplantRecipient transplantRecipient) {
        return TransplantRecipientDTO.builder()
                .registrationDate(transplantRecipient.getRegistrationDate())
                .fullName(transplantRecipient.getFullName())
                .address(transplantRecipient.getAddress())
                .dateOfBirth(transplantRecipient.getDateOfBirth())
                .identification(transplantRecipient.getIdentification())
                .nationality(transplantRecipient.getNationality())
                .imc(transplantRecipient.getImc())
                .stateOfUrgency(transplantRecipient.getStateOfUrgency().getDescription())
                .stateOfUrgencyDate(transplantRecipient.getStateOfUrgencyDate() == null ? new Date() : transplantRecipient.getStateOfUrgencyDate())
                .bloodType(transplantRecipient.getBloodType().getDescription())
                .build();
    }

    public TransplantRecipientListDTO toListDTO(final TransplantRecipient transplantRecipient){
        return TransplantRecipientListDTO.builder()
                .registrationDate(this.dateFormat(transplantRecipient.getRegistrationDate()))
                .fullName(transplantRecipient.getFullName())
                .dateOfBirth(this.dateFormat(transplantRecipient.getDateOfBirth()))
                .indentification(transplantRecipient.getIdentification())
                .nationality(transplantRecipient.getNationality())
                .stateOfUrgency(transplantRecipient.getStateOfUrgency().getDescription())
                .stateOfUrgenyDate(this.dateFormat(transplantRecipient.getStateOfUrgencyDate()))
                .bloodType(transplantRecipient.getBloodType().getDescription()).build();
    }

    public PageDTO<TransplantRecipientListDTO> toPageDTO(Page<TransplantRecipient> transplantRecipient){
        List<TransplantRecipientListDTO> list = transplantRecipient.getContent().stream().map(e -> toListDTO(e)).collect(Collectors.toList());
        return new PageDTO<TransplantRecipientListDTO>(
                list,
                transplantRecipient.getNumber(),
                transplantRecipient.getSize(),
                transplantRecipient.getTotalElements(),
                transplantRecipient.getTotalPages()
        );
    }
}
