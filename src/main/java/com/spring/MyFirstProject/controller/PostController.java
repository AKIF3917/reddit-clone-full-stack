package com.spring.MyFirstProject.controller;

import com.spring.MyFirstProject.model.Post;
import com.spring.MyFirstProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {

        postService.deletePost(id);

        return "Post Deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public Post updatePost(@PathVariable Long id,
                           @RequestBody Post post) {

        return postService.updatePost(id, post);
    }
}