package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.*;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.*;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.TransplantDonorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TransplantDonorServiceImpl implements TransplantDonorService{

    @Autowired
    private TransplantDonorRepository transplantDonorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BloodTypeRepository bloodTypeRepository;
    @Autowired
    private OrganTypeRepository organTypeRepository;
    @Autowired
    private HLATypeRepository hlaTypeRepository;
    @Autowired
    private OrgansToDonateRepository organsToDonateRepository;
    @Autowired
    private HLATransplantDonorRepository hlaTransplantDonorRepository;
    @Autowired
    private TransplantDonorConverter transplantDonorConverter;
    @Autowired
    private SharedService sharedService;


    @Override
    public ResponseDTO createTransplantDonor(TransplantDonorDTO transplantDonorDTO) {
        try{
            Optional<BloodType> bloodTypeOptional = this.bloodTypeRepository.findBloodTypeByDescription(transplantDonorDTO.getBloodType());
            if(bloodTypeOptional.isEmpty()) {
                return new ResponseDTO(false, "Blood type not found", StatusCode.NOT_FOUND.getValue());
            }

            List<OrganType> organTypes = this.organTypeRepository.findOrganTypesByListOfDescriptions(transplantDonorDTO.getOrgansToDonate());
            List<HLAType> hlaTypes = this.hlaTypeRepository.findHLATypesByListOfDescriptions(transplantDonorDTO.getHlaTypes());

            TransplantDonor transplantDonor = transplantDonorConverter.toEntity(transplantDonorDTO);
            transplantDonor.setBloodType(bloodTypeOptional.get());

            this.transplantDonorRepository.save(transplantDonor);

            this.organsToDonateRepository.saveAll(organTypes.stream().map(ot -> new OrgansToDonate(transplantDonor, ot)).toList());
            this.hlaTransplantDonorRepository.saveAll(hlaTypes.stream().map(hlat -> new HLATransplantDonor(transplantDonor, hlat)).toList());

        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }

        return new ResponseDTO(true, "", StatusCode.CREATED.getValue());
    }

    @Override
    public ResponseDTO findAll() {
        List<TransplantDonorDTO> transplantDonorDTOS = this.transplantDonorRepository.findAll().stream().map(td -> this.transplantDonorConverter.toDTO(td)).toList();
        return new ResponseDTO(true, transplantDonorDTOS, StatusCode.OK.getValue());
    }

    @Override
    public Page<TransplantDonor> findAllByText(String text, String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(TransplantDonorDTO.class, orderBy, sortOrder, pageNumber,pageSize);
        if(text != null){
            return transplantDonorRepository.findAllByFullName(text, pageable);
        } else {
            return transplantDonorRepository.findAll(pageable);
        }
    }

    @Override
    public Page<TransplantDonor> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize){
        Pageable pageable = sharedService.buildPageable(TransplantDonorDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return transplantDonorRepository.findAll(pageable);
    }
}
