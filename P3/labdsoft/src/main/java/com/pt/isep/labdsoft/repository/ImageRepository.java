package com.pt.isep.labdsoft.repository;

import com.pt.isep.labdsoft.entity.domain.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findByName(String name);
}
