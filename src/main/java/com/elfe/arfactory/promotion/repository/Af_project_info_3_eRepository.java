package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_3_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_5_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_3_eRepository extends JpaRepository<Af_project_info_3_eEntity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_3_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_3_eEntity> findByApi1seq(Long Api1_seq);

    // admin 상세정보_e 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_3_E" , nativeQuery = true)
    List<Af_project_info_3_eEntity> getAPI3EAllData();

    // admin 상세정보_e 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_3_E where API3E_SEQ =:no" , nativeQuery = true)
    Af_project_info_3_eEntity getAPI3eData(Long no);

    // admin 상세정보_e 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_3_E where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI3eData(Long no);

    // admin 상세정보_e 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_3_E SET API3E_CONTENT1 =:c1, API3E_CONTENT2 =:c2, API3E_UDATETIME =:sdf where API3E_SEQ =:no" , nativeQuery = true)
    void updateAPI3eData(Long no, String c1, String c2, LocalDateTime sdf);

}
