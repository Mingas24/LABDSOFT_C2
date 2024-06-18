package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProtocolRepository extends JpaRepository<Protocol, Long> {

    Optional<Protocol> findProtocolByProtocol(String protocol);
}
