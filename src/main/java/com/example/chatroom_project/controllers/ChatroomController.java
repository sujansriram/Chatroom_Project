package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chatrooms")
public class ChatroomController {

    @Autowired
    ChatroomService chatroomService;

    @Autowired
    ChatroomRepository chatroomRepository;


//    GET
    @GetMapping
    public ResponseEntity<List<Chatroom>>displayAllChatrooms(){
        return new ResponseEntity<>(chatroomRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Optional<Chatroom>>displayChatroomById(@PathVariable Long id){
        return new ResponseEntity<>(chatroomRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Optional<Chatroom>>displayChatroomById(@PathVariable Long id){
        return new ResponseEntity<>(chatroomRepository.findById(id), HttpStatus.OK);
    }







}
