package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import org.springframework.data.domain.Page;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantedOrganDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantedOrgan;

public interface TransplantedOrganService {
    
    ResponseDTO addTransplantedOrgan(TransplantedOrganDTO transplantedOrganDTO);

    PageDTO<TransplantedOrganDTO> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize);
}
