package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_4_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_4_eRepository extends JpaRepository<Af_project_info_4_eEntity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_4_eEntity> findByApi1seq(Long Api1_seq);

    // admin 활용사례_e 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4_E" , nativeQuery = true)
    List<Af_project_info_4_eEntity> getAPI4EAllData();

    // admin 활용사례_e 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_4_E where API4E_SEQ =:no" , nativeQuery = true)
    Af_project_info_4_eEntity getAPI4eData(Long no);

    // admin 활용사례_e 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_4_E where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI4eData(Long no);

    // admin 활용사례_e 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_4_E SET API4E_CONTENT1 =:c1, API4E_CONTENT2 =:c2, API4E_CONTENT3 =:c3, API4E_CONTENT4 =:c4, API4E_UDATETIME =:sdf where API4E_SEQ =:no" , nativeQuery = true)
    void updateAPI4eData(Long no, String c1, String c2, String c3, String c4, LocalDateTime sdf);

}
