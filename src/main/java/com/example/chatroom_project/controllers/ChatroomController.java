package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.ChatroomDTO;
import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.services.ChatroomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


//@Transactional
@RestController
@RequestMapping(value = "/chatrooms")
public class ChatroomController {

    @Autowired
    ChatroomService chatroomService;


//    INDEX
    @GetMapping
    public ResponseEntity<List<Chatroom>> displayAllChatrooms(){
        return new ResponseEntity<>(chatroomService.getAllChatrooms(), HttpStatus.OK);
    }

//    SHOW
    @GetMapping( value = "/{id}")
    public ResponseEntity<Chatroom> displayChatroomById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(chatroomService.getChatroomById(id), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    // EDIT:
    @GetMapping(value = "/{chatroomId}/edit")
    public ResponseEntity<Chatroom> editChatroomName (@PathVariable Long chatroomId){
        Chatroom foundChatroomName = chatroomService.getChatroomById(chatroomId);
        return new ResponseEntity<>(foundChatroomName, HttpStatus.OK);
    }

    //    UPDATE:
    @PutMapping(value = "{chatroomId}")
    public ResponseEntity<Chatroom> updateChatroomName (@PathVariable Long chatroomId, @RequestBody ChatroomDTO chatroomDTO){
        Chatroom updateChatroomName =  chatroomService.updateChatroomName(chatroomDTO, chatroomId);
        return new ResponseEntity<>(updateChatroomName, HttpStatus.OK);
    }


    //    CREATE

    @PostMapping
    public ResponseEntity<Chatroom> createChatroom(@RequestBody Chatroom chatroom){
        return new ResponseEntity<>(chatroomService.createChatroom(chatroom), HttpStatus.OK);
    }

//    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteChatroom(@PathVariable Long id){
        try {
            chatroomService.deleteChatroom(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


// UPDATE
    @PatchMapping(value = "/{chatroomId}/users/{userId}/add")
    public ResponseEntity<List<User>> addUserToChatroom(@PathVariable Long chatroomId, @PathVariable Long userId){
        return new ResponseEntity<>(chatroomService.addUserToChatroom(userId, chatroomId), HttpStatus.OK);
    }

//    UPDATE
    @PatchMapping(value = "/{chatroomId}/users/{userId}/remove")
    public ResponseEntity<List<User>> removeUserFromChatroom(@PathVariable Long chatroomId, @PathVariable Long userId){
        try {
            return new ResponseEntity<>(chatroomService.removeUserFromChatroom(userId, chatroomId), HttpStatus.OK);
        } catch(NullPointerException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

//    SHOW


}
