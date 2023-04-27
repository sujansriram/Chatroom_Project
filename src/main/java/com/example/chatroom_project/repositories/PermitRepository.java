package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Long> {

    @Query(value = "SELECT * FROM permits WHERE (permits.user_id = :userId) AND (permits.chatroom_id = :chatroomId)", nativeQuery = true)
    Permit findByUserIdAndChatroomId(@Param("userId") Long userId, @Param("chatroomId") Long chatroomId);

    void deleteByUserId(Long userId);

    void deleteByChatroomId(Long chatroomId);

}
