package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findUsersByRoleDescription(String roleDescription);

    List<User> findAll();
}
