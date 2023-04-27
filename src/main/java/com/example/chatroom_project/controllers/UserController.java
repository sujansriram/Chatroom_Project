package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.MessageDTO;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.MessageRepository;

import com.example.chatroom_project.models.*;
import com.example.chatroom_project.repositories.PermitRepository;

import com.example.chatroom_project.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PermitRepository permitRepository;


    @GetMapping
    public ResponseEntity<List<User>> displayAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> displayUserById (@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/email/{id}")
    public ResponseEntity<User> changeEmail(@PathVariable Long id, @RequestBody String email){
        return new ResponseEntity<>(userService.updateUserEmail(email, id), HttpStatus.OK);
    }

    @PatchMapping(value = "/name/{id}")
    public ResponseEntity<User> changeName(@PathVariable Long id, @RequestBody String name){
        return new ResponseEntity<>(userService.updateUserName(name, id), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/chatrooms")
    public ResponseEntity<List<Chatroom>> displayChatroomsByUser (@PathVariable Long userId){
        return new ResponseEntity<>(userService.displayChatroomsByUserId(userId), HttpStatus.OK);
    }

}
