package com.spring.MyFirstProject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("file")
            MultipartFile file
    ) throws IOException {

        String fileName =
                System.currentTimeMillis()
                        + "_"
                        + file.getOriginalFilename();

        File uploadDir =
                new File("uploads");

        if(!uploadDir.exists()) {

            uploadDir.mkdir();
        }

        file.transferTo(
                new File(
                        "uploads/" + fileName
                )
        );

        return "uploads/" + fileName;
    }
}