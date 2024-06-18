package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransplantDonorRepository extends PagingAndSortingRepository<TransplantDonor, Long> {

    Optional<TransplantDonor> findByFullName(String fullName);

    List<TransplantDonor> findAll();

    Page<TransplantDonor> findAll(Pageable pageable);

    Page<TransplantDonor> findAllByFullName(String fullName, Pageable pageable);

}
