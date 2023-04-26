package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatroomRepository extends JpaRepository <Chatroom, Long> {

//    @Query("SELECT DISTINCT chatroom_id FROM messages" + " WHERE userId = :id")
//    List<Chatroom> findByUserId(@Param("id") Long id);


}
