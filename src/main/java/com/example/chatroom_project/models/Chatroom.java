package com.example.chatroom_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "chatrooms")
public class Chatroom {

//PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "chatroom")
    @JsonIgnoreProperties("chatroom")
    private List<Message> messages;

//    private enum userType;

    private List<User> users;


//CONSTRUCTOR
    public Chatroom (String name){
        this.name = name;
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
    }
//DEFAULT CONSTRUCTOR
    public Chatroom(){

    }

//GETTERS AND SETTERS
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}