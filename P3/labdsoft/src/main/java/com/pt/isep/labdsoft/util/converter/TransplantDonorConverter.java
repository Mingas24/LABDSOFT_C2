package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorListDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
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
public class TransplantDonorConverter {

    public String dateFormat(Date dateToFormat){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(dateToFormat);
        return formattedDate;
    }

    public TransplantDonor toEntity(final TransplantDonorDTO transplantDonorDTO){
        return TransplantDonor.builder()
                .fullName(transplantDonorDTO.getFullName())
                .deathDate(transplantDonorDTO.getDeathDate())
                .harvestDate(transplantDonorDTO.getHarvestDate())
                .category(transplantDonorDTO.getCategory()).build();
    }

    public TransplantDonorDTO toDTO(final TransplantDonor transplantDonor){
        return TransplantDonorDTO.builder()
                .fullName(transplantDonor.getFullName())
                .deathDate(transplantDonor.getDeathDate())
                .harvestDate(transplantDonor.getHarvestDate())
                .bloodType(transplantDonor.getBloodType().getDescription())
                .build();
    }

    public TransplantDonorListDTO toListDTO(final TransplantDonor transplantDonor){
        return TransplantDonorListDTO.builder()
                .fullName(transplantDonor.getFullName())
                .deathDate(this.dateFormat(transplantDonor.getDeathDate()))
                .harvestDate(this.dateFormat(transplantDonor.getHarvestDate()))
                .category(transplantDonor.getCategory())
                .build();
    }

    public PageDTO<TransplantDonorListDTO> toPageDTO(Page<TransplantDonor> transplantDonor) {
        List<TransplantDonorListDTO> list = transplantDonor.getContent().stream().map(e -> toListDTO(e)).collect(Collectors.toList());
        return new PageDTO<TransplantDonorListDTO>(
                list,
                transplantDonor.getNumber(),
                transplantDonor.getSize(),
                transplantDonor.getTotalElements(),
                transplantDonor.getTotalPages()
        );
    }
}
