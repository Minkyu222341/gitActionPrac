//package com.sparta.mini.repository;
//
//import com.sparta.mini.model.RefreshToken;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
//    Optional<RefreshToken> findByRefresh_key(String key);
//}