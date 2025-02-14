package com.webknot.UserService.Service;

import com.webknot.UserService.Dto.UserProfilesDto;
import com.webknot.UserService.Entity.*;
import com.webknot.UserService.Exception.MetroException;
import com.webknot.UserService.Repository.*;
//import com.webknot.UserService.UserServiceApplication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserProfileService {
    private final UserProfileRepository userRepository;
    private final MetroCardRepository metroCardRepository;
    private final TravelHistoryRepository travelHistoryRepository;

    public UserProfile addUser(UserProfilesDto user) {
        UserProfile users = UserProfile.builder()
                .name(user.getName())
                .email(user.getEmail())
                .contact(user.getContact())
                .build();
        return userRepository.save(users);
    }

    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    public UserProfile getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new MetroException("User not found with ID: " + userId));
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
