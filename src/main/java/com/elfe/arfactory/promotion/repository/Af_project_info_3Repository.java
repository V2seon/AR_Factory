package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_3Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_3Repository extends JpaRepository<Af_project_info_3Entity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_3 where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_3Entity> findByApi1seq(Long Api1_seq);

    // admin 상세정보 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_3" , nativeQuery = true)
    List<Af_project_info_3Entity> getAPI3AllData();

    // admin 상세정보 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_3 where API3_SEQ =:no" , nativeQuery = true)
    Af_project_info_3Entity getAPI3Data(Long no);

    // admin 상세정보 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_3 where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI3Data(Long no);

    // admin 상세정보 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_3 SET API3_CONTENT1 =:c1, API3_CONTENT2 =:c2, API3_UDATETIME =:sdf where API3_SEQ =:no" , nativeQuery = true)
    void updateAPI3Data(Long no, String c1, String c2, LocalDateTime sdf);

}
