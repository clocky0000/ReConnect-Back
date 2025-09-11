package com.example.ReConnect.service;

import com.example.ReConnect.dto.UserDto;
import com.example.ReConnect.entity.User;
import com.example.ReConnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserDto dto) {
        User user = User.toUser(dto);
        if (!isArgon2Hash(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    public boolean isIdExists(String id) {
        return userRepository.existsById(id);
    }

    public UserDto login(UserDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElse(null);
        if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return UserDto.toDto(user);
        }
        return null;
    }

    public UserDto findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? UserDto.toDto(user) : null;
    }

    // 연인 코드 생성
    @Transactional
    public UserDto assignCoupleCode(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        // 이전 연인과 관계 해제
        if (user.getCoupleCode() != null && user.getPartnerId() != null) {
            User partner = userRepository.findById(user.getPartnerId()).orElse(null);
            if (partner != null) {
                partner.setCoupleCode(null);
                partner.setPartnerId(null);
                userRepository.save(partner);
            }
            user.setCoupleCode(null);
            user.setPartnerId(null);
        }

        String coupleCode;
        do {
            coupleCode = UUID.randomUUID().toString().substring(0, 8);
        }while(userRepository.findByCoupleCode(coupleCode).isPresent());

        user.setCoupleCode(coupleCode);

        userRepository.save(user);

        return UserDto.toDto(user);
    }

    @Transactional
    public UserDto connectWithCoupleCode(String userId, String coupleCode) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        User partner = userRepository.findByCoupleCode(coupleCode)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연인 코드입니다."));

        if (partner.getUserId().equals(userId)) {
            throw new IllegalArgumentException("자기 자신의 코드는 입력할 수 없습니다.");
        }

        user.setPartnerId(partner.getUserId());
        partner.setPartnerId(user.getUserId());

        user.setCoupleCode(partner.getCoupleCode());

        userRepository.save(partner);

        userRepository.save(user);

        return UserDto.toDto(user);
    }

    private boolean isArgon2Hash(String s) {
        return s != null && s.startsWith("$argon2");
    }
}
