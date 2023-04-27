package com.example.chatroom_project.services;

import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.MessageDTO;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.repositories.MessageRepository;
import com.example.chatroom_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    public Message sendMessage(MessageDTO messageDTO) {
        String inputMessage = messageDTO.getMessage();
        User user = userRepository.findById(messageDTO.getUserId()).get();
        Chatroom chatroom = chatroomRepository.findById(messageDTO.getChatroomId()).get();
        Message message = new Message(inputMessage, user, chatroom);
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

}
