package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantCandidateDTO;
import com.pt.isep.labdsoft.dto.domain.VitalSignsPageDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantCandidate;
import com.pt.isep.labdsoft.entity.domain.VitalSigns;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class VitalSignsConverter {

    public VitalSignsPageDTO toListDTO(final VitalSigns vitalSigns){
        return VitalSignsPageDTO.builder()
                .healthTrackerIdentifier(vitalSigns.getHealthTrackerIdentifier())
                .bloodPressure(vitalSigns.getBloodPressure())
                .bodyTemperature(vitalSigns.getBodyTemperature())
                .heartRate(vitalSigns.getHeartRate())
                .stability(vitalSigns.getStability())
                .build();
    }

    public PageDTO<VitalSignsPageDTO> toPageDTO(Page<VitalSigns> vitalSigns) {
        List<VitalSignsPageDTO> list = vitalSigns.getContent().stream().map(e -> toListDTO(e)).collect(Collectors.toList());
        return new PageDTO<VitalSignsPageDTO>(
                list,
                vitalSigns.getNumber(),
                vitalSigns.getSize(),
                vitalSigns.getTotalElements(),
                vitalSigns.getTotalPages()
        );
    }
}
