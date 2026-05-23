package com.spring.MyFirstProject.controller;

import com.spring.MyFirstProject.model.Comment;
import com.spring.MyFirstProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @GetMapping("/all")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }
}