package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_4_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_2_eRepository extends JpaRepository<Af_project_info_2_eEntity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_2_eEntity> findByApi1seq(Long Api1_seq);

    // admin 콘텐츠_e 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2_E" , nativeQuery = true)
    List<Af_project_info_2_eEntity> getAPI2EAllData();

    // admin 콘텐츠_e 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2_E where API2E_SEQ =:no" , nativeQuery = true)
    Af_project_info_2_eEntity getAPI2eData(Long no);

    // admin 콘텐츠_e 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_2_E where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI2eData(Long no);

    // admin 콘텐츠_e 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_2_E SET API2E_CONTENTS =:text, API2E_IMG1 =:img1, API2E_IMG2 =:img2, API2E_IMG3 =:img3, API2E_IMG4 =:img4, API2E_IMG5 =:img5, API2E_IMG6 =:img6, API2E_UDATETIME =:sdf where API2E_SEQ =:no" , nativeQuery = true)
    void updateAPI2eData(Long no, String text, String img1, String img2, String img3, String img4, String img5, String img6, LocalDateTime sdf);

}
