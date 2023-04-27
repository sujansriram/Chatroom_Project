package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.services.ChatroomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping(value = "/chatrooms")
public class ChatroomController {

    @Autowired
    ChatroomService chatroomService;


//    GET
    @GetMapping
    public ResponseEntity<List<Chatroom>> displayAllChatrooms(){
        return new ResponseEntity<>(chatroomService.getAllChatrooms(), HttpStatus.OK);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Chatroom> displayChatroomById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(chatroomService.getChatroomById(id), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Chatroom> createChatroom(@RequestBody Chatroom chatroom){
        return new ResponseEntity<>(chatroomService.createChatroom(chatroom), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteChatroom(@PathVariable Long id){
        try {
            chatroomService.deleteChatroom(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/addUser/{id}")
    public ResponseEntity<List<User>> addUserToChatroom(@PathVariable Long id, @RequestBody Long userId){
        if (chatroomService.addUserToChatroom(userId, id) == null){
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        } else {
            return new ResponseEntity<>(chatroomService.addUserToChatroom(userId, id), HttpStatus.OK);
        }
    }

    @PatchMapping(value = "/removeUser/{id}")
    public ResponseEntity<List<User>> removeUserFromChatroom(@PathVariable Long id, @RequestBody Long userId){
        try {
            return new ResponseEntity<>(chatroomService.removeUserFromChatroom(userId, id), HttpStatus.OK);
        } catch(NullPointerException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
