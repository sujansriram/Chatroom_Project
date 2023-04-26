package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatroomIdOrderByTimeDesc(Long id);

}
