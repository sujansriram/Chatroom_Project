package com.example.chatroom_project.repositories;

import com.example.chatroom_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
