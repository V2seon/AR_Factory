package com.elfe.arfactory.promotion.repository;

import com.elfe.arfactory.promotion.entity.Af_inqEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface Af_inqRepository extends JpaRepository<Af_inqEntity, Long> {

    // admin 문의 페이지 list 데이터 가져오기
    @Query(value = "SELECT * FROM AF_INQ ORDER BY AI_SEQ ASC" , nativeQuery = true)
    Page<Af_inqEntity> findAIAllList(Pageable pageable);

    // admin 문의 페이지 모든 데이터 불러오기
    @Query(value = "SELECT * FROM AF_INQ" , nativeQuery = true)
    List<Af_inqEntity> getAIAllData();

    // admin 문의 페이지 데이터 불러오기
    @Query(value = "SELECT * FROM AF_INQ where AI_SEQ =:no" , nativeQuery = true)
    Af_inqEntity getAIData(Long no);

    // admin 리뷰 페이지 데이터 수정(비밀번호 포함)
    @Modifying
    @Transactional
    @Query(value = "UPDATE AF_INQ SET API1_SEQ=:pac, AI_NAME =:name, AI_PHONE =:phon, AI_OPT =:opt, AI_STATE =:state, AI_STATE2 =:state2, AI_UDATETIME =:sdf where AI_SEQ =:no" , nativeQuery = true)
    void updateAIData(Long no, Long pac, String name, String phon, int opt, int state, int state2, LocalDateTime sdf);

}
