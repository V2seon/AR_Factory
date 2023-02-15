package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_project_info_2_eEntity;
import com.elfe.arfactory.promotion.entity.Af_reviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Af_reviewRepository extends JpaRepository<Af_reviewEntity, Long> {

    // promotion
    // 후기 상태값 1인 리스트 점수 높은것들 상위 5개
    @Query(value = "SELECT * FROM AF_REVIEW where API1_SEQ=:num and AR_STATE =1 order by AR_STAR desc limit 5" , nativeQuery = true)
    List <Af_reviewEntity> findAll5(Long num);

    // promotion
    // 후기 상태값 1인 리스트 전부 가져오기
    @Query(value = "SELECT * FROM AF_REVIEW where API1_SEQ=:num and AR_STATE =1" , nativeQuery = true)
    List <Af_reviewEntity> findlistcount(Long num);

    // promotion
    // 후기 상태값 1인 리스트 전부 가져오기
    @Query(value = "SELECT AR_STAR FROM AF_REVIEW where AR_STATE =1 " , nativeQuery = true)
    List <Af_reviewEntity> findlistcount1();


//    @Query(value = "SELECT * FROM AF_PROJECT_INFO_2_E where API1_SEQ =:Api1_seq" , nativeQuery = true)
//    Optional<Af_project_info_2_eEntity> findByApi1seq(Long Api1_seq);
}
