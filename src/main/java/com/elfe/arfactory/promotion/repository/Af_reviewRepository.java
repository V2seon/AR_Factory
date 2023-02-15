package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_reviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

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


    // admin 리뷰 페이지 list 데이터 가져오기
    @Query(value = "SELECT * FROM AF_REVIEW ORDER BY AR_SEQ DESC " , nativeQuery = true)
    Page<Af_reviewEntity> findARAllList(Pageable pageable);

    // admin 리뷰 페이지 데이터 수 체크(name)
    @Query(value = "SELECT COUNT(AR_NAME) FROM AF_REVIEW where AR_NAME =:name" , nativeQuery = true)
    int checkARData(String name);

    // admin 리뷰 페이지 데이터 수 체크(seq)
    @Query(value = "SELECT COUNT(*) FROM AF_REVIEW where AR_SEQ =:no" , nativeQuery = true)
    int checkARSeq(Long no);

    // admin 리뷰 페이지 데이터 불러오기
    @Query(value = "SELECT * FROM AF_REVIEW where AR_SEQ =:no" , nativeQuery = true)
    Af_reviewEntity getARData(Long no);

    // admin 리뷰 페이지 데이터 삭제
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM AF_REVIEW WHERE AR_SEQ =:no", nativeQuery = true)
    void deleteARData(Long no);

    // admin 리뷰 페이지 데이터 수정(비밀번호 포함)
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_REVIEW SET API1_SEQ=:pac, AR_NAME =:name, AR_CONTENT =:text, AR_STAR =:star, AR_PASSWORD =:pw, AR_STATE =:state, AR_UDATETIME =:sdf where AR_SEQ =:no" , nativeQuery = true)
    void updateARData(Long no, Long pac, String name, String text, float star, String pw, int state, LocalDateTime sdf);

    // admin 리뷰 페이지 데이터 수정(비밀번호 미포함)
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_REVIEW SET API1_SEQ=:pac, AR_NAME =:name, AR_CONTENT =:text, AR_STAR =:star, AR_STATE =:state, AR_UDATETIME =:sdf where AR_SEQ =:no" , nativeQuery = true)
    void updateARData(Long no, Long pac, String name, String text, float star, int state, LocalDateTime sdf);

}
