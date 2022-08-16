package com.sparta.mini.repository;

import com.sparta.mini.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
   Optional<Member> findByUsername(String username);

   Optional<Member> findByNickname(String nickname);
   boolean existsByUsername(String nickname);
   boolean existsByNickname(String username);
   boolean existsByPassword(String password);


}