package com.spring.MyFirstProject.repository;

import com.spring.MyFirstProject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}