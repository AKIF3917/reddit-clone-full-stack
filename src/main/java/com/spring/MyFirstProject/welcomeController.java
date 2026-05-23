package com.spring.MyFirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController {
     @GetMapping("/welcome")
    public String welcome(){
         return "welcome to spring boot world!";
     }
}
