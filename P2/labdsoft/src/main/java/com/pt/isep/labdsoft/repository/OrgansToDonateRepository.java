package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.OrgansToDonate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrgansToDonateRepository extends PagingAndSortingRepository<OrgansToDonate, Long> {
}
