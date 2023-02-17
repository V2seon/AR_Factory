package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_2Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Af_project_info_2Repository extends JpaRepository<Af_project_info_2Entity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2 where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_2Entity> findByApi1seq(Long Api1_seq);

    // admin 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2" , nativeQuery = true)
    List<Af_project_info_2Entity> getAPI2AllData();

    // admin 콘텐츠 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2 where API2_SEQ =:no" , nativeQuery = true)
    Af_project_info_2Entity getAPI2Data(Long no);

    // admin 콘텐츠 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_2 where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI2Data(Long no);

}
