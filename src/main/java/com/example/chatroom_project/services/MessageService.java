package com.example.chatroom_project.services;

import com.example.chatroom_project.models.*;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.repositories.MessageRepository;
import com.example.chatroom_project.repositories.PermitRepository;
import com.example.chatroom_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    PermitRepository permitRepository;

    public Message sendMessage(MessageDTO messageDTO) {
        String inputMessage = messageDTO.getMessage();
        User user = userRepository.findById(messageDTO.getUserId()).get();
        Chatroom chatroom = chatroomRepository.findById(messageDTO.getChatroomId()).get();
        Permit permit = permitRepository.findByUserIdAndChatroomId(user.getId(),chatroom.getId());
        if (permit.getPermit()) {
            Message message = new Message(inputMessage, user, chatroom);
            return messageRepository.save(message);
        } else {
            return null;
        }
    }

    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

    public List<Message> findMessagesForChatroomTimeDesc(Long id) {
        return messageRepository.findByChatroomIdOrderByTimeDesc(id);
    }

}
