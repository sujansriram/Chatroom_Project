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
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PermitRepository permitRepository;



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
        User user = userRepository.findById(userId).get();
        Chatroom chatroom = chatroomRepository.findById(chatroomId).get();
        Message message = new Message(inputMessage, user, chatroom);
        return messageRepository.save(message);
    }
    public List<Chatroom> displayChatroomsByUserId(Long id){
        User user = userRepository.findById(id).get();
        return user.getChatrooms();
    }


    public User updateUser(UserDTO userDTO, Long userId) {
        User userToUpdate = userRepository.findById(userId).get();
        userToUpdate.setName(userDTO.getName());
        userToUpdate.setEmail(userDTO.getEmail());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }
}
