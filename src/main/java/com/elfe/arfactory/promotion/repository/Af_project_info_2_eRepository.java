package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Af_project_info_2_eRepository extends JpaRepository<Af_project_info_2_eEntity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_2_eEntity> findByApi1seq(Long Api1_seq);
}
