package com.example.chatroom_project.services;

import com.example.chatroom_project.models.ImageData;
import com.example.chatroom_project.repositories.ImageRepository;
import com.example.chatroom_project.util.ImageUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

//  Spring web gives us this multipartfile
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = imageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }


    @Transactional
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = imageRepository.findByName(fileName);
        System.out.println(dbImageData.get().getName());
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());         // returning the object as a byte array. once we get the file we are decompressing it.
        return images;
    }
//
}
