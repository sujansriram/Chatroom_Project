package com.example.chatroom_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user", "chatroom"})
    private List<Message> messages;


    @JsonIgnoreProperties({"users", "messages"})
    @ManyToMany
    @JoinTable(
            name = "users_chatrooms",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chatroom_id")
    )
    private List<Chatroom> chatrooms;

    public User(String name, String email){
        this.name = name;
        this.email = email;
        this.messages = new ArrayList<>();
        this.chatrooms = new ArrayList<>();
    }
    
//    Default constructor
    public User(){

    }

//    Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void addChatroom(Chatroom chatroom){
        this.chatrooms.add(chatroom);
    }

    public void removeChatroom(Chatroom chatroom){
        this.chatrooms.remove(chatroom);
    }

}
