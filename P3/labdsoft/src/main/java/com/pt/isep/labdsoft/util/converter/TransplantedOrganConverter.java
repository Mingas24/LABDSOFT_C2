package com.pt.isep.labdsoft.util.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantCandidateDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantedOrganDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantCandidate;
import com.pt.isep.labdsoft.entity.domain.TransplantedOrgan;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class TransplantedOrganConverter {

    public TransplantedOrganDTO toListDTO(final TransplantedOrgan transplantedOrgan){
        return TransplantedOrganDTO.builder()
                .fullName(transplantedOrgan.getFullName())
                .transplantedOrgan(transplantedOrgan.getTransplantedOrgan())
                .transplantationDate(transplantedOrgan.getTransplantationDate())
                .build();
    }

    public PageDTO<TransplantedOrganDTO> toPageDTO(Page<TransplantedOrgan> transplantedOrgan) {
        List<TransplantedOrganDTO> list = transplantedOrgan.getContent().stream().map(e -> toListDTO(e)).collect(Collectors.toList());
        return new PageDTO<TransplantedOrganDTO>(
                list,
                transplantedOrgan.getNumber(),
                transplantedOrgan.getSize(),
                transplantedOrgan.getTotalElements(),
                transplantedOrgan.getTotalPages()
        );
    }

    public TransplantedOrgan toEntity(final TransplantedOrganDTO transplantedOrganDTO){
        return TransplantedOrgan.builder()
                .fullName(transplantedOrganDTO.getFullName())
                .transplantedOrgan(transplantedOrganDTO.getTransplantedOrgan())
                .transplantationDate(transplantedOrganDTO.getTransplantationDate()).build();
    }

}
