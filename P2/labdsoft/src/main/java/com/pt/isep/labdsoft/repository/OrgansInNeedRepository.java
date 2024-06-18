package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.OrgansInNeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrgansInNeedRepository extends PagingAndSortingRepository<OrgansInNeed, Long> {
}
