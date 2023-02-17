package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_5_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_5_eRepository extends JpaRepository<Af_project_info_5_eEntity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_5_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_5_eEntity> findByApi1seq(Long Api1_seq);

    // admin 구입방식_e 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_5_E" , nativeQuery = true)
    List<Af_project_info_5_eEntity> getAPI5EAllData();

    // admin 구입방식_e 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_5_E where API5E_SEQ =:no" , nativeQuery = true)
    Af_project_info_5_eEntity getAPI5eData(Long no);

    // admin 구입방식_e 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_5_E where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI5eData(Long no);

    // admin 구입방식_e 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_5_E SET API5E_CONTENT1 =:p1, API5E_CONTENT2 =:p2, API5E_CONTENT3 =:p3, API5E_UDATETIME =:sdf where API5E_SEQ =:no" , nativeQuery = true)
    void updateAPI5eData(Long no, String p1, String p2, String p3, LocalDateTime sdf);

}
