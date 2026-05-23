package com.spring.MyFirstProject.repository;

import com.spring.MyFirstProject.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}