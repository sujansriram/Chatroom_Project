package com.example.chatroom_project.services;

import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.repositories.ChatroomRepository;
import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatroomService {

    @Autowired
    UserService userService;

    @Autowired
    ChatroomRepository chatroomRepository;
//
//    public Chatroom getAllChatrooms(){
//        return chatroomRepository.findAll();
//    }
//
//    public List<Chatroom> getAllChatroomsById(Long id){
//        return chatroomRepository.findById(id).get();
//    }


// GET NAME - DISPLAY CHATROOM TITLE

// GET ALL MESSAGES - STACKS - sorted by user, by time
    // getChatroomByUser -get chatroom(), getUser()

//  ADD INPUT - ADDING A MESSAGE (set message in Message)





}
