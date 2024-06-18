package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.DonorSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface DonorSampleRepository  extends PagingAndSortingRepository<DonorSample, Long> {

    Optional<DonorSample> findBySampleIdentification(String sampleIdentification);

    List<DonorSample> findAll();

}
