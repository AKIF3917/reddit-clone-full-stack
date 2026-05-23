package com.spring.MyFirstProject.controller;

import com.spring.MyFirstProject.model.Vote;
import com.spring.MyFirstProject.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/create")
    public Vote createVote(@RequestBody Vote vote) {
        return voteService.saveVote(vote);
    }

    @GetMapping("/all")
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }
    @GetMapping("/upvotes/{postId}")
    public int getUpvotes(@PathVariable Long postId) {

        return voteService.getUpvotes(postId);
    }

    @GetMapping("/downvotes/{postId}")
    public int getDownvotes(@PathVariable Long postId) {

        return voteService.getDownvotes(postId);
    }
}