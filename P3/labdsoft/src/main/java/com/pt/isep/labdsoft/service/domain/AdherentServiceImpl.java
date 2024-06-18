package com.pt.isep.labdsoft.service.domain;


import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AdherentDTO;
import com.pt.isep.labdsoft.entity.domain.Adherent;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.AdherentRepository;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.AdherentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class AdherentServiceImpl implements AdherentService {

    @Autowired
    private AdherentRepository adherentRepository;

    @Autowired
    private SharedService sharedService;

    @Autowired
    private AdherentConverter adherentConverter;


    @Override
    public ResponseDTO createAdherent(AdherentDTO adherentDTO) {
        try {

            Adherent adherent = adherentConverter.toEntity(adherentDTO);
            this.adherentRepository.save(adherent);

        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    @Override
    public Page<Adherent> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(AdherentDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return adherentRepository.findAll(pageable);
    }

    @Override
    public Page<Adherent> findByCelebrity(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize){
        Pageable pageable = sharedService.buildPageable(AdherentDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        String text = "Sim";
        return adherentRepository.findAllByCelebrityContainingIgnoreCase(text, pageable);
    }

}
