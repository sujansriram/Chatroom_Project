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



    public Chatroom getChatroom(Long id){
        // GET NAME - DISPLAY CHATROOM TITLE
        Chatroom chatroom =  chatroomRepository.findById(id).get();
             String chatroomName = chatroom.getName();
        // GET ALL MESSAGES - STACKS - sorted by user

//      GET CHATROOM ID FROM DTO CLASS WHERE CHATROOM ID = DTO


//        GET USER ID AND CHATROOM ID FROM MESSAGEDTO CONSTRUCTOR


    }

//



    // getChatroomByUser -get chatroom(), getUser()

//  ADD INPUT - ADDING A MESSAGE (set message in Message)





}
