package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageData, Long> {

    // method to find image by name:
    Optional<ImageData> findByName(String name);   // could just return but using the Optional is better practice
}
