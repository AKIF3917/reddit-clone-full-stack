package com.spring.MyFirstProject.repository;

import com.spring.MyFirstProject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}