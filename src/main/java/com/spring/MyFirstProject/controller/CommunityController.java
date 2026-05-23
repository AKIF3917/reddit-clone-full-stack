package com.spring.MyFirstProject.controller;

import com.spring.MyFirstProject.model.Community;
import com.spring.MyFirstProject.service.CommunityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping("/create")
    public Community createCommunity(@RequestBody Community community) {

        return communityService.saveCommunity(community);
    }

    @GetMapping("/all")
    public List<Community> getAllCommunities() {

        return communityService.getAllCommunities();
    }
}