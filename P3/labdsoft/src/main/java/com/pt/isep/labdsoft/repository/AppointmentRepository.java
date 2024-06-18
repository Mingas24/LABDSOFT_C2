package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.auth.User;
import com.pt.isep.labdsoft.entity.domain.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

    Optional<List<Appointment>> findAllByCreatedDt(Date appointmentDate);

    Page<Appointment> findAll(Pageable pageable);
}
