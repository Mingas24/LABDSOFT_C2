package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.VitalSigns;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitalSignsRepository extends PagingAndSortingRepository<VitalSigns, Long> {
    Page<VitalSigns> findAll(Pageable pageable);
}
