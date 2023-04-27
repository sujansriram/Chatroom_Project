package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.UserDTO;
import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.MessageRepository;

import com.example.chatroom_project.repositories.PermitRepository;

import com.example.chatroom_project.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PermitRepository permitRepository;

// SHOW:
    @GetMapping
    public ResponseEntity<List<User>> displayAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


//    INDEX:
    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> displayUserById (@PathVariable Long userId) {
        try {
            return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // EDIT:
    @GetMapping(value = "/{userId}/edit")
    public ResponseEntity<User> editUser (@PathVariable Long userId){
        User foundUser = userService.getUserById(userId);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    //    UPDATE:
    @PutMapping(value = "{userId}")
    public ResponseEntity<User> updateUser (@PathVariable Long userId, @RequestBody UserDTO userDTO){
        User updateUser = userService.updateUser(userDTO, userId);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }


//    CREATE
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

//    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


// SHOW
    @GetMapping(value = "/{userId}/chatrooms")
    public ResponseEntity<List<Chatroom>> displayChatroomsByUser (@PathVariable Long userId){
        try {
            return new ResponseEntity<>(userService.displayChatroomsByUserId(userId), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
