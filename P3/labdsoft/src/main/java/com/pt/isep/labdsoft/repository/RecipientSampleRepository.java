package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.RecipientSample;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface RecipientSampleRepository extends PagingAndSortingRepository<RecipientSample, Long> {

    Optional<RecipientSample> findBySampleIdentification(String sampleIdentification);

    List<RecipientSample> findAll();
}
