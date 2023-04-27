package com.example.chatroom_project.models;

public class UserDTO {

//    Properties
    private String name;
    private String email;

    public UserDTO(String name, String email){
        this.name = name;
        this.email = email;
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
}
