package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantCandidateDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.dto.ui.UITransplantCandidatesDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantCandidate;
import com.pt.isep.labdsoft.enums.StatusCode;
import com.pt.isep.labdsoft.repository.TransplantCandidateRepository;
import com.pt.isep.labdsoft.service.shared.SharedService;
import com.pt.isep.labdsoft.util.converter.TransplantCandidateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class TransplantCandidateServiceImpl implements TransplantCandidateService {

    @Autowired
    private TransplantCandidateRepository transplantCandidatesRepository;
    @Autowired
    private SharedService sharedService;
    @Autowired
    private TransplantCandidateConverter transplantCandidateConverter;

    @Override
    public PageDTO<TransplantCandidateDTO> getTransplantCandidates(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize) {
        Pageable pageable = sharedService.buildPageable(TransplantDonorDTO.class, orderBy, sortOrder, pageNumber, pageSize);
        return transplantCandidateConverter.toPageDTO(this.transplantCandidatesRepository.findAll(pageable));
    }

    @Override
    public ResponseDTO getTransplantCandidates() {
        UITransplantCandidatesDTO candidates = UITransplantCandidatesDTO.builder().candidates(this.transplantCandidatesRepository.findAll().stream().map(e -> e.getFullName()).collect(Collectors.toList())).build();
        return new ResponseDTO(true, candidates,StatusCode.OK.getValue());
    }

    @Override
    public ResponseDTO getCandidatePosition(String fullName, String organ) {
        try{
        List<TransplantCandidate> tcList = transplantCandidatesRepository.findAll();
        List<TransplantCandidate> tcListFilter = new ArrayList<>();
        TransplantCandidate tcUser = new TransplantCandidate();
        for(TransplantCandidate tc : tcList){
            if(tc.getOrganForTransplant().equals(organ)){
                tcListFilter.add(tc);
            }
            if(tc.getFullName().equals(fullName)){
                tcUser = tc;
            }
        }
        TransplantCandidate temp;
        for (int x=0; x<tcListFilter.size(); x++)
        {
            for (int i=0; i < tcListFilter.size()-x-1; i++) {
                if ((tcListFilter.get(i).getPoints().compareTo(tcListFilter.get(i+1).getPoints())) < 0){
                    temp = tcListFilter.get(i);
                    tcListFilter.set(i,tcListFilter.get(i+1) );
                    tcListFilter.set(i+1, temp);
                }
            }
        }
        if(!tcListFilter.contains(tcUser)){
           return new ResponseDTO(false, "O orgão procurado não está associado ao recetor", StatusCode.NOT_FOUND.getValue());
        }
            return new ResponseDTO(true,tcListFilter.indexOf(tcUser)+1 , StatusCode.OK.getValue());
        } catch (Exception ex) {
            return new ResponseDTO(false, ex.getMessage(), StatusCode.OPERATION_EXCEPTION.getValue());
        }

    }
}
