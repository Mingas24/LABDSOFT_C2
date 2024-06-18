package com.pt.isep.labdsoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pt.isep.labdsoft.entity.domain.TransplantedOrgan;

@Repository
public interface TransplantedOrganRepository extends PagingAndSortingRepository<TransplantedOrgan, Long>  {

    Optional<TransplantedOrgan> findByFullName(String fullName);

    List<TransplantedOrgan> findAll();

    Page<TransplantedOrgan> findAll(Pageable pageable);

    Page<TransplantedOrgan> findAllByFullName(String fullName, Pageable pageable);

    
}
