package com.example.chatroom_project.models;

public class ChatroomDTO {

    private String name;

    public ChatroomDTO(String name){
        this.name = name;
    }


    public ChatroomDTO(){

    }

//    Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
