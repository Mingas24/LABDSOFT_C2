package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.HLATransplantDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HLATransplantDonorRepository extends PagingAndSortingRepository<HLATransplantDonor, Long> {
}
