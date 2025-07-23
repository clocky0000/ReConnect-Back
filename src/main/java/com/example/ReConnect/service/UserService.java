package com.example.ReConnect.service;

import com.example.ReConnect.dto.UserDto;
import com.example.ReConnect.entity.User;
import com.example.ReConnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserDto dto) {
        User user = User.toUser(dto);
        userRepository.save(user);
    }

    public boolean isIdExists(String id) {
        return userRepository.existsById(id);
    }

    public UserDto login(UserDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElse(null);
        if (user != null && user.getPassword().equals(dto.getPassword())) {
            return UserDto.toDto(user);
        }
        return null;
    }

    public UserDto findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? UserDto.toDto(user) : null;
    }
}
