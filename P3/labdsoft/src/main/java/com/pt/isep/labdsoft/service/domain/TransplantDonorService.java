package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.PageDTO;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantDonorDTO;
import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
import org.springframework.data.domain.Page;

public interface TransplantDonorService {

    ResponseDTO createTransplantDonor(TransplantDonorDTO transplantDonorDTO);

    ResponseDTO findAll();

    Page<TransplantDonor> findAllByText(String text, String ordery, String sortOrder, Integer pageNumber, Integer pageSize);

    Page<TransplantDonor> findAll(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize);
}
