package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.VitalsAppointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface VitalsAppointmentRepository extends PagingAndSortingRepository<VitalsAppointment, Long> {

    Optional<List<VitalsAppointment>> findAllByCreatedDt(Date appointmentDate);

    Page<VitalsAppointment> findAll(Pageable pageable);
}
