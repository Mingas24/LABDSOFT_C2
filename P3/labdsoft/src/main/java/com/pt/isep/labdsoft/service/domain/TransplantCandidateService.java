package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantCandidateDTO;


public interface TransplantCandidateService {

    PageDTO<TransplantCandidateDTO> getTransplantCandidates(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize);
    ResponseDTO getTransplantCandidates();
    ResponseDTO getCandidatePosition(String fullName, String organ);
}
