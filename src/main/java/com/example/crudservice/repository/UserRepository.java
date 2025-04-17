package com.example.crudservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}