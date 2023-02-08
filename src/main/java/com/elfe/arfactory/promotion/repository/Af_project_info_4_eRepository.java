package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_4_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Af_project_info_4_eRepository extends JpaRepository<Af_project_info_4_eEntity, Long> {

    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_4_eEntity> findByApi1seq(Long Api1_seq);

}
