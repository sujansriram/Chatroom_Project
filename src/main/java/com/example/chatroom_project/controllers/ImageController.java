package com.example.chatroom_project.controllers;

import com.example.chatroom_project.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}/")
    public ResponseEntity<?> downloadImage(@PathVariable(name = "fileName") String fileName){
        byte[] imageData= imageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

//
}
