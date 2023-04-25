package com.example.chatroom_project.services;

import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.MessageDTO;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.repositories.MessageRepository;
import com.example.chatroom_project.repositories.UserRepository;
import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatroomService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    public List<Chatroom> getAllChatrooms(){
        return chatroomRepository.findAll();
    }

    public Chatroom getChatroomById(Long id){
        return chatroomRepository.findById(id).get();
    }

    public Chatroom createChatroom(Chatroom chatroom) {
        return chatroomRepository.save(chatroom);
    }

    public void deleteChatroom(Long id) {
        chatroomRepository.deleteById(id);
    }

    public void addUserToChatroom(Long userId, Long chatroomId) {
        MessageDTO addMessage = new MessageDTO("user has been added", chatroomId, userId);
        User user = userRepository.findById(userId).get();
        Chatroom chatroom = chatroomRepository.findById(chatroomId).get();
        Message message = new Message("user has been added", user, chatroom);
        messageRepository.save(message);
    }
//
//    public void removeUserFromChatroom(Long userId, Long chatroomId) {
//        User user = userRepository.findById(userId).get();
//        Chatroom chatroom = chatroomRepository.findById(chatroomId).get();
//        chatroom.removeUser(user);
//    }



}
