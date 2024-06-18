package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.TransplantDonor;
import com.pt.isep.labdsoft.entity.domain.TransplantRecipient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TransplantRecipientRepository extends PagingAndSortingRepository<TransplantRecipient, Long> {

    Optional<TransplantRecipient> findByFullName(String fullName);

    List<TransplantRecipient> findAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE cito.DOM_TRANSPLANT_RECIPIENT SET C_STATE_OF_URGENCY = :stateOfUrgency WHERE C_FULL_NAME = :fullName",
            nativeQuery = true)
    int updateUrgencyStatus(@Param("fullName") String fullName, @Param("stateOfUrgency") int stateOfUrgency);

    Page<TransplantRecipient> findAll(Pageable pageable);

    Page<TransplantRecipient> findAllByFullName(String fullName, Pageable pageable);

    Optional<TransplantRecipient> findTransplantRecipientByIdentification(String identification);
    Optional<TransplantRecipient> findByIdentification(String identification);

}
