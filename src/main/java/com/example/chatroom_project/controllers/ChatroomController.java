package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return new ResponseEntity<>(chatroomService.getChatroomById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chatroom> createChatroom(@RequestBody Chatroom chatroom){
        return new ResponseEntity<>(chatroomService.createChatroom(chatroom), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteChatroom(@PathVariable Long id){
        chatroomService.deleteChatroom(id);
        return new ResponseEntity<>(String.format("chatroom of id %s has been deleted", id), HttpStatus.OK);
    }

    @PatchMapping(value = "/addUser/{id}")
    public ResponseEntity<String> addUserToChatroom(@PathVariable Long id, @RequestBody Long userId){
        chatroomService.addUserToChatroom(userId, id);
        return new ResponseEntity<>(String.format("user of id %s has been added to chatroom of id %s", userId, id), HttpStatus.OK);
    }
//
//    @PatchMapping(value = "/removeUser/{id}")
//    public ResponseEntity<String> removeUserFromChatroom(@PathVariable Long id, @RequestBody Long userId){
//        chatroomService.removeUserFromChatroom(userId, id);
//        return new ResponseEntity<>(String.format("user of id %s has been removed from chatroom of id %s", userId, id), HttpStatus.OK);
//    }





}
