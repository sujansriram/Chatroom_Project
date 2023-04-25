package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;

public interface MessageRepository extends JpaRepository<Message, Long> {
//     Collections.reverse(messages);
}
