package com.example.chatroom_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "messages")
public class Message {

    //    PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String message;

    @Column
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"messages"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    @JsonIgnoreProperties({"messages"})
    private Chatroom chatroom;

//    CONSTRUCTOR

    public Message(String message, User user, Chatroom chatroom){
        this.message = message;
        this.time = LocalTime.now();
        this.user = user;
        this.chatroom = chatroom;
    }

//    DEFAULT CONSTRUCTOR

    public Message(){

    }

//    GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
