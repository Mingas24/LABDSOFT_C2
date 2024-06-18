package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantCandidateDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantCandidate;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class TransplantCandidateConverter {

    public TransplantCandidateDTO toListDTO(final TransplantCandidate transplantCandidate){
        return TransplantCandidateDTO.builder()
                .fullName(transplantCandidate.getFullName())
                .points(transplantCandidate.getPoints())
                .bloodType(transplantCandidate.getBloodType())
                .organForTransplant(transplantCandidate.getOrganForTransplant())
                .urgencyState(transplantCandidate.getUrgencyState())
                .build();
    }

    public PageDTO<TransplantCandidateDTO> toPageDTO(Page<TransplantCandidate> transplantCandidate) {
        List<TransplantCandidateDTO> list = transplantCandidate.getContent().stream().map(e -> toListDTO(e)).collect(Collectors.toList());
        return new PageDTO<TransplantCandidateDTO>(
                list,
                transplantCandidate.getNumber(),
                transplantCandidate.getSize(),
                transplantCandidate.getTotalElements(),
                transplantCandidate.getTotalPages()
        );
    }
}
