package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.AppointmentManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentManagementRepository extends PagingAndSortingRepository<AppointmentManagement, Long> {

    Optional<List<AppointmentManagement>> findAllByAppointmentManagementDate(Date appointmentManagementDate);

    Optional<List<AppointmentManagement>> findAllByPatientIdentification(String identification);

    Optional<List<AppointmentManagement>> findAllByPatientIdentificationAndAppointmentManagementDate(String identification, Date appointmentManagementDate);

    Page<AppointmentManagement> findAll(Pageable pageable);
}
