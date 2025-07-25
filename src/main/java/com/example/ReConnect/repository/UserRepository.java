package com.example.ReConnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ReConnect.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
