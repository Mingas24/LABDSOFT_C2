package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientDTO;

import com.pt.isep.labdsoft.dto.domain.UpdateRecipientUrgencyStatusDTO;

import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import org.springframework.data.domain.Page;


public interface TransplantRecipientService {
    ResponseDTO createTransplantRecipient(TransplantRecipientDTO transplantRecipientDTO);

    ResponseDTO getTransplantRecipients();

    ResponseDTO getTransplantRecipientByIdentification(String identification);

    ResponseDTO updateRecipientStatus(UpdateRecipientUrgencyStatusDTO updateRecipientUrgencyStatusDTO);

    Page<TransplantRecipient> findAllByText(String text, String ordery, String sortOrder, Integer pageNumber, Integer pageSize);

    Page<TransplantRecipient> findAll(String ordery, String sortOrder, Integer pageNumber, Integer pageSize);

}
