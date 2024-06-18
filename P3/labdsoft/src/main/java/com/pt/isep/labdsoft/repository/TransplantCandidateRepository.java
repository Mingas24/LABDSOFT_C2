package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.TransplantCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface TransplantCandidateRepository extends PagingAndSortingRepository<TransplantCandidate, Long> {
    Page<TransplantCandidate> findAll(Pageable pageable);
    List<TransplantCandidate> findAll();
}
