package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_project_info_6Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Af_project_info_6Repository extends JpaRepository<Af_project_info_6Entity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_6 where API1_SEQ =:Api1_seq" , nativeQuery = true)
    Optional<Af_project_info_6Entity> findByApi1seq(Long Api1_seq);


    // admin 옵션 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_6" , nativeQuery = true)
    List<Af_project_info_6Entity> getAPI6AllData();

    // admin 옵션 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_6 where API6_SEQ =:no" , nativeQuery = true)
    Af_project_info_6Entity getAPI6Data(Long no);

    // admin 옵션 데이터 체크
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_6 where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI6Data(Long no);

    // admin 옵션 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_6 SET API6_OPT1 =:o1, API6_OPT2 =:o2, API6_OPT3 =:o3, API6_OPT4 =:o4, API6_OPT5 =:o5, API6_OPT6 =:o6, API6_OPT7 =:o7, API6_UDATETIME =:sdf where API6_SEQ =:no" , nativeQuery = true)
    void updateAPI6Data(Long no, String o1, String o2, String o3, String o4, String o5, String o6, String o7, LocalDateTime sdf);

}
