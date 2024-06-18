package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.OrganWastageDTO;
import com.pt.isep.labdsoft.entity.domain.OrganType;
import com.pt.isep.labdsoft.entity.domain.OrganWastage;
import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.OrganTypeRepository;
import com.pt.isep.labdsoft.repository.OrganWastageRepository;
import com.pt.isep.labdsoft.repository.TransplantDonorRepository;
import com.pt.isep.labdsoft.service.domain.OrganWastageService;
import com.pt.isep.labdsoft.util.converter.OrganWastageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class OrganWastageServiceImpl implements OrganWastageService {


    @Autowired
    private OrganWastageRepository organWastageRepository;

    @Autowired
    private TransplantDonorRepository transplantDonorRepository;

    @Autowired
    private OrganTypeRepository organTypeRepository;

    @Autowired
    private OrganWastageConverter organWastageConverter;

    @Override
    public ResponseDTO registerOrganWastage(OrganWastageDTO organWastageDTO) {
        try {
            Optional<TransplantDonor> transplantDonorOptional = this.transplantDonorRepository.findByFullName(organWastageDTO.getPatientIdentification());
            if (transplantDonorOptional.isEmpty()) {
                return new ResponseDTO(false, "Transplant Donor is not registered.", StatusCode.NOT_FOUND.getValue());
            }

            Optional<OrganType> organTypeOptional = this.organTypeRepository.findOrganTypeByDescription(organWastageDTO.getOrganType());
            if (organTypeOptional.isEmpty()) {
                return new ResponseDTO(false, "Organ type is not registered.", StatusCode.NOT_FOUND.getValue());
            }

            OrganWastage organWastage = this.organWastageConverter.toEntity(organTypeOptional.get(),transplantDonorOptional.get());
            this.organWastageRepository.save(organWastage);

            return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }
    }
}