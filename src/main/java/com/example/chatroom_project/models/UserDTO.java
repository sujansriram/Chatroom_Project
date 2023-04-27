package com.example.chatroom_project.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {




//    Properties
    private String name;
    private String email;

    private List<Message> messages;
    private List<Chatroom> chatrooms;


    public UserDTO(String name, String email){
        this.name = name;
        this.email = email;
        this.messages = new ArrayList<>();
        this.chatrooms = new ArrayList<>();
    }

//    Default constructor
    public UserDTO(){

    }

//    Getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Chatroom> getChatrooms() {
        return chatrooms;
    }

    public void setChatrooms(List<Chatroom> chatrooms) {
        this.chatrooms = chatrooms;
    }
}
