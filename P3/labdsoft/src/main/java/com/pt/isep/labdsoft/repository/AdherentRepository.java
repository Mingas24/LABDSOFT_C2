package com.pt.isep.labdsoft.repository;


import com.pt.isep.labdsoft.entity.domain.Adherent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdherentRepository extends PagingAndSortingRepository<Adherent, Long> {

    //Page<Adherent> findAll(Pageable pageable);

    //List<Adherent> findAll();

    Page<Adherent> findAllByCelebrityContainingIgnoreCase(String text, Pageable pageable);

}
