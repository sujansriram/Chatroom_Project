package com.example.chatroom_project.services;

import com.example.chatroom_project.models.*;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.repositories.MessageRepository;
import com.example.chatroom_project.repositories.PermitRepository;
import com.example.chatroom_project.repositories.UserRepository;
import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatroomService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PermitRepository permitRepository;

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

    public List<Chatroom> deleteChatroom(Long chatroomId) {
        Chatroom existingChatroom = chatroomRepository.findById(chatroomId).orElse(null);
        if(existingChatroom == null) {
            return null;
        } else {
            chatroomRepository.deleteById(chatroomId);
            messageRepository.deleteByChatroomId(chatroomId);
            for (User user : existingChatroom.getUsers()){
                user.getChatrooms().remove(existingChatroom);
                userRepository.save(user);
            }
            return chatroomRepository.findAll();
        }
    }

    public List<User> addUserToChatroom(Long userId, Long chatroomId){
        User user = userRepository.findById(userId).get();
        Chatroom chatroom = chatroomRepository.findById(chatroomId).get();

        if (chatroom.getUsers().contains(user)){
            return null;
        } else {
            user.addChatroom(chatroom);
            Permit permit = new Permit(true, user, chatroom);
            permitRepository.save(permit);
            userRepository.save(user);
            return chatroom.getUsers();
        }
    }


    public List<User> removeUserFromChatroom(Long userId, Long chatroomId) {
        User user = userRepository.findById(userId).get();
        Chatroom chatroom = chatroomRepository.findById(chatroomId).get();
        user.removeChatroom(chatroom);
        Permit permit = permitRepository.findByUserIdAndChatroomId(userId, chatroomId);
        permit.setPermit(false);
        permitRepository.save(permit);
        userRepository.save(user);
        return chatroom.getUsers();

    }


    public List<Message> findMessagesForChatroomTimeDesc(Long id) {
        return messageRepository.findByChatroomIdOrderByTimeDesc(id);

    }
}
