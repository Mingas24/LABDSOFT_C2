package com.pt.isep.labdsoft.service.domain;

import javax.transaction.Transactional;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.service.shared.SharedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantedOrganDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantedOrgan;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.TransplantCandidateRepository;
import com.pt.isep.labdsoft.repository.TransplantedOrganRepository;
import com.pt.isep.labdsoft.util.converter.TransplantedOrganConverter;

@Transactional
@Service
public class TransplantedOrganServiceImpl implements TransplantedOrganService {

    @Autowired
    private TransplantedOrganConverter transplantedOrganConverter;

    @Autowired
    private TransplantedOrganRepository transplantedOrganRepository;

    @Autowired
    private SharedService sharedService;

    @Override
    public ResponseDTO addTransplantedOrgan(TransplantedOrganDTO transplantedOrganDTO) {
        try{
            this.transplantedOrganRepository.save(transplantedOrganConverter.toEntity(transplantedOrganDTO));
            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        }catch(Exception ex){
            return new ResponseDTO(false,ex.getMessage(),StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }

    @Override
    public PageDTO<TransplantedOrganDTO> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(TransplantDonorDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return transplantedOrganConverter.toPageDTO(this.transplantedOrganRepository.findAll(pageable));

    }
    
}
