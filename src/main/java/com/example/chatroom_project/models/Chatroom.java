package com.example.chatroom_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


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
    @JsonIgnoreProperties({"chatroom","user"})
    private List<Message> messages;

    @JsonIgnoreProperties({"chatrooms", "messages"})
    @ManyToMany(mappedBy = "chatrooms")
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

    public void addMessage(Message message){
        this.messages.add(message);
        Collections.reverse(this.messages);
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

}
