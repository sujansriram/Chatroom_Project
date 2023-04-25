package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
