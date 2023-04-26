package com.example.chatroom_project.components;

import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.repositories.UserRepository;
import com.example.chatroom_project.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomService chatroomService;


    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Chatroom chatroom1 = new Chatroom("room1");
        Chatroom chatroom2 = new Chatroom("room2");
        Chatroom chatroom3 = new Chatroom("room3");
        Chatroom chatroom4 = new Chatroom("room4");

        User user1 = new User("Sujan", "sujan@gmail.com");
        User user2 = new User("Natasha", "natasha@gmail.com");
        User user3 = new User("Sarah", "sarah@gmail.com");
        User user4 = new User("Zaynah", "zaynah@gmail.com");



        chatroomRepository.save(chatroom1);
        chatroomRepository.save(chatroom2);
        chatroomRepository.save(chatroom3);
        chatroomRepository.save(chatroom4);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        chatroomService.addUserToChatroom(1L, 1L);
        chatroomService.addUserToChatroom(2L, 2L);
        chatroomService.addUserToChatroom(3L, 3L);
        chatroomService.addUserToChatroom(4L, 1L);

    }

}
