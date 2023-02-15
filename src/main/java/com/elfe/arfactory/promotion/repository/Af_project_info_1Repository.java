package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_1Entity;
import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.List;

public interface Af_project_info_1Repository extends JpaRepository<Af_project_info_1Entity, Long> {

    // promotion
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_1 where API1_STATE =:num" , nativeQuery = true)
    List <Af_project_info_1Entity> findAll(Long num);

    // admin 솔루션 페이지 list 데이터 가져오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_1 ORDER BY API1_SEQ ASC" , nativeQuery = true)
    Page<Af_project_info_1Entity> findAPI1AllList(Pageable pagebl);

    // admin 솔루션 페이지 데이터 수 체크(name)
    @Query(value = "SELECT COUNT(API1_SEQ) FROM AF_PROJECT_INFO_1 where API1_NAME =:name" , nativeQuery = true)
    int checkAPI1Data(String name);

    // admin 솔루션 페이지 데이터 수 체크(seq)
    @Query(value = "SELECT COUNT(*) FROM AF_PROJECT_INFO_1 where API1_SEQ =:no" , nativeQuery = true)
    int checkAPI1Seq(Long no);

    // admin 솔루션 페이지 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_1 where API1_SEQ =:no" , nativeQuery = true)
    Af_project_info_1Entity getAPI1Data(Long no);

    // admin 솔루션 페이지 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_PROJECT_INFO_1" , nativeQuery = true)
    List<Af_project_info_1Entity> getAPI1AllData();

    // admin 솔루션 페이지 데이터 수정
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_PROJECT_INFO_1 SET API1_NAME =:name, API1_TYPE =:type, API1_NAME_E =:name_e, API1_TYPE_R =:type_e, API1_PLAYSTORE =:googleLink, API1_APPSTORE =:appleLink, API1_VIEW_SEQ =:mainNum, API1_STATE =:show, API1_UDATETIME =:sdf where API1_SEQ =:no" , nativeQuery = true)
    void updateAPI1Data(Long no, String name, String type, String name_e, String type_e, String googleLink, String appleLink, int mainNum, int show, LocalDateTime sdf);

    // admin 솔루션 페이지 데이터 삭제
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM AF_PROJECT_INFO_1 WHERE API1_SEQ =:no", nativeQuery = true)
    void deleteAPI1Data(Long no);
}
