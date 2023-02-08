package com.elfe.arfactory.admin.repository;

import com.elfe.arfactory.admin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByAaidAndAapw(String A_ID, String A_PW);

    Optional<UserEntity> findByAaid(String A_ID);
}