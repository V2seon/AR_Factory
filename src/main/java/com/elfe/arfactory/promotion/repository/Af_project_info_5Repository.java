package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_5Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_5Repository extends JpaRepository<Af_project_info_5Entity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_5 where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_5Entity> findByApi1seq(Long Api1_seq);

    // admin 구입방식 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_5" , nativeQuery = true)
    List<Af_project_info_5Entity> getAPI5AllData();

    // admin 구입방식 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_5 where API5_SEQ =:no" , nativeQuery = true)
    Af_project_info_5Entity getAPI5Data(Long no);

    // admin 구입방식 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_5 where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI5Data(Long no);

    // admin 구입방식 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_5 SET API5_CONTENT1 =:p1, API5_CONTENT2 =:p2, API5_CONTENT3 =:p3, API5_UDATETIME =:sdf where API5_SEQ =:no" , nativeQuery = true)
    void updateAPI5Data(Long no, String p1, String p2, String p3, LocalDateTime sdf);

}
