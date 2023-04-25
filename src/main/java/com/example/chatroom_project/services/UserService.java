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

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    MessageRepository messageRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUserEmail(String email, Long userId) {
        User user = userRepository.findById(userId).get();
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User updateUserName(String name, Long userId) {
        User user = userRepository.findById(userId).get();
        user.setName(name);
        return userRepository.save(user);
    }
    public Message sendMessage(String inputMessage, Long userId, Long chatroomId) {
//      find the user and find the chatroom using their Ids
        User user = userRepository.findById(userId).get();
        Chatroom chatroom = chatroomRepository.findById(chatroomId).get();

//      use the user and chatroom to create a new message
        Message message = new Message(inputMessage, user, chatroom);

////        add the message to the chatroom
//        chatroom.addMessage(message);

//        saving the message to the messageRepository
        return messageRepository.save(message);
    }

}
