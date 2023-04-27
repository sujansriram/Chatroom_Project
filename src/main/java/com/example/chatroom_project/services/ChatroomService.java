package com.example.chatroom_project.services;

import com.example.chatroom_project.models.*;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.repositories.MessageRepository;
import com.example.chatroom_project.repositories.PermitRepository;
import com.example.chatroom_project.repositories.UserRepository;
import jakarta.persistence.AttributeOverride;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
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

    public void deleteChatroom(Long id) {
        Chatroom chatroom = chatroomRepository.findById(id).get();
        for (User user : chatroom.getUsers()){
            user.removeChatroom(chatroom);
        }
        permitRepository.deleteByChatroomId(id);
        chatroomRepository.deleteById(id);
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
