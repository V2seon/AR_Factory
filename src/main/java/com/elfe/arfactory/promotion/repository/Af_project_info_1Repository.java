package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface Af_project_info_1Repository extends JpaRepository<Af_project_info_1Entity, Long> {

    @Query(value = "SELECT * FROM AF_PROJECT_INFO_1 where API1_STATE =:num" , nativeQuery = true)
    List <Af_project_info_1Entity> findAll(Long num);

}
