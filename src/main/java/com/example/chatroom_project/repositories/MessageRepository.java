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
    @Query (value = "SELECT * FROM messages ORDER BY time DESC", nativeQuery = true)
    List<Message> findByOrderByTimeDesc();



//    @Query("SELECT * FROM messages " + "ORDER BY time ASC")
//    List<Message> messages = repository.findAll(Sort.by(Sort.Direction.ASC, "time"));
//
//
//    @Query(value = "SELECT * FROM permits WHERE (permits.user_id = :userId) AND (permits.chatroom_id = :chatroomId)", nativeQuery = true)
//    Permit findByUserIdAndChatroomId(@Param("userId") Long userId, @Param("chatroomId") Long chatroomId);
}
