package com.pt.isep.labdsoft.util.converter;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.AdherentDTO;
import com.pt.isep.labdsoft.dto.domain.AdherentListDTO;
import com.pt.isep.labdsoft.entity.domain.Adherent;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class AdherentConverter {

    public Adherent toEntity(final AdherentDTO adherentDTO) throws IOException {
        return Adherent.builder()
                .fullName(adherentDTO.getFullName())
                .age(adherentDTO.getAge())
                .nationality(adherentDTO.getNationality())
                .job(adherentDTO.getJob())
                .celebrity(adherentDTO.getCelebrity())
        .build();
    }

    public AdherentDTO toDTO(final Adherent adherent){
        return AdherentDTO.builder()
                .fullName(adherent.getFullName())
                .age(adherent.getAge())
                .nationality(adherent.getNationality())
                .job(adherent.getJob())
                .celebrity(adherent.getCelebrity()).build();
    }

    public AdherentListDTO toListDTO(final Adherent adherent){
        return AdherentListDTO.builder()
                .fullName(adherent.getFullName())
                .age(adherent.getAge())
                .nationality(adherent.getNationality())
                .job(adherent.getJob())
                .celebrity(adherent.getCelebrity()).build();
    }

    public PageDTO<AdherentListDTO> toPageDTO(Page<Adherent> adherent){
        List<AdherentListDTO> list = adherent.getContent().stream().map(e -> toListDTO(e)).collect(Collectors.toList());
        return new PageDTO<AdherentListDTO>(
                list,
                adherent.getNumber(),
                adherent.getSize(),
                adherent.getTotalElements(),
                adherent.getTotalPages()
        );
    }
}
