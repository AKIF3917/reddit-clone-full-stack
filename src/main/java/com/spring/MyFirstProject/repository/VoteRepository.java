package com.spring.MyFirstProject.repository;

import com.spring.MyFirstProject.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    int countByPostIdAndValue(Long postId, int value);
    Vote findByPostIdAndUserEmail(Long postId, String userEmail);
}