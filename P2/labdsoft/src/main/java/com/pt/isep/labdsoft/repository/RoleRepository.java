package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Optional<Role> findRoleById(Long id);
}
