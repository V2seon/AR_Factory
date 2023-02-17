package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6_eEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_6_eRepository extends JpaRepository<Af_project_info_6_eEntity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_6_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_6_eEntity> findByApi1seq(Long Api1_seq);


    // admin 옵션_e 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_6_E" , nativeQuery = true)
    List<Af_project_info_6_eEntity> getAPI6EAllData();

    // admin 옵션_e 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_6_E where API6E_SEQ =:no" , nativeQuery = true)
    Af_project_info_6_eEntity getAPI6eData(Long no);

    // admin 옵션_e 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_6_E where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI6eData(Long no);

    // admin 옵션_e 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_6_E SET API6E_OPT1 =:o1, API6E_OPT2 =:o2, API6E_OPT3 =:o3, API6E_OPT4 =:o4, API6E_OPT5 =:o5, API6E_OPT6 =:o6, API6E_OPT7 =:o7, API6E_UDATETIME =:sdf where API6E_SEQ =:no" , nativeQuery = true)
    void updateAPI6eData(Long no, String o1, String o2, String o3, String o4, String o5, String o6, String o7, LocalDateTime sdf);

}
