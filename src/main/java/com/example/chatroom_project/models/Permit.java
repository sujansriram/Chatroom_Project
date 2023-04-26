package com.example.chatroom_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "permits")
public class Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private boolean permit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"messages"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    @JsonIgnoreProperties({"messages"})
    private Chatroom chatroom;

    public Permit(boolean permit, User user, Chatroom chatroom){
        this.permit = permit;
        this.user = user;
        this.chatroom = chatroom;
    }

    public Permit(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getPermit() {
        return permit;
    }

    public void setPermit(boolean permit) {
        this.permit = permit;
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
}
