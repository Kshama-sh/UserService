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

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }


//    public List<TravelHistory> getTravelHistory(Long userId) {
//        return travelHistoryRepository.findTop10ByUserIdOrderByTravelTimeDesc(userId);
//    }
//
//    public String cancelMetroCard(Long userId) {
//        Optional<Object> metroCard = metroCardRepository.findByUserId(userId);
//
//        if (metroCard.isEmpty()) {
//            throw new RuntimeException("User does not have a metro card");
//        }
//
//        List<TravelHistory> history = travelHistoryRepository.findTop10ByUserIdOrderByTravelTimeDesc(userId);
//        if (!history.isEmpty()) {
//            throw new RuntimeException("Metro card cannot be canceled as it has been used");
//        }
//
//        metroCardRepository.delete((MetroCard) metroCard.get());
//        return "Metro card successfully canceled";
//    }
//
//    public UserProfile getUserProfile(Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
}
