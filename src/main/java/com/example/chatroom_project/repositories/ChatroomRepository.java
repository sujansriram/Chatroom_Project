package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends JpaRepository <Chatroom, Long> {
}
