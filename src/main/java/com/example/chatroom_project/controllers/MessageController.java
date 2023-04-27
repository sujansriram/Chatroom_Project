package com.example.chatroom_project.controllers;
import com.example.chatroom_project.models.MessageDTO;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.Permit;
import com.example.chatroom_project.repositories.PermitRepository;
import com.example.chatroom_project.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    PermitRepository permitRepository;


    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO messageDTO){
        return new ResponseEntity<>(messageService.sendMessage(messageDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMessage(@PathVariable Long id){
        try {
            messageService.deleteMessage(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{chatroomId}")
    public ResponseEntity<List<Message>> retrieveMessagesForChatroom(@PathVariable Long chatroomId){
        return new ResponseEntity<>(messageService.findMessagesForChatroomTimeDesc(chatroomId), HttpStatus.OK);
    }

}
