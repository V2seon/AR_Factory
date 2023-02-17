package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_4Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_4Repository extends JpaRepository<Af_project_info_4Entity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4 where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_4Entity> findByApi1seq(Long Api1_seq);

    // admin 활용사례 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4" , nativeQuery = true)
    List<Af_project_info_4Entity> getAPI4AllData();

    // admin 활용사례 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4 where API4_SEQ =:no" , nativeQuery = true)
    Af_project_info_4Entity getAPI4Data(Long no);

    // admin 활용사례 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_4 where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI4Data(Long no);

    // admin 활용사례 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_4 SET API4_CONTENT1 =:c1, API4_CONTENT2 =:c2, API4_CONTENT3 =:c3, API4_CONTENT4 =:c4, API4_UDATETIME =:sdf where API4_SEQ =:no" , nativeQuery = true)
    void updateAPI4Data(Long no, String c1, String c2, String c3, String c4, LocalDateTime sdf);
}
