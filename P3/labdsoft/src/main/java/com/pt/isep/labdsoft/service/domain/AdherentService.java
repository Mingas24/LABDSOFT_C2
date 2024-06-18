package com.pt.isep.labdsoft.service.domain;

import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.dto.domain.AdherentDTO;
import com.pt.isep.labdsoft.dto.domain.TransplantRecipientDTO;
import com.pt.isep.labdsoft.entity.domain.Adherent;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;


public interface AdherentService {

    ResponseDTO createAdherent(AdherentDTO adherentDTO);

    Page<Adherent> findAll( String orderBy, String sortOrder, Integer pageNumber, Integer pageSize);

    Page<Adherent> findByCelebrity(String orderBy, String sortOrder, Integer pageNumber, Integer pageSize);


}
