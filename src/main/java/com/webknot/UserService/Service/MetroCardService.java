package com.webknot.UserService.Service;

import com.webknot.UserService.Dto.MetroCardDto;
import com.webknot.UserService.Entity.MetroCard;
import com.webknot.UserService.Entity.UserProfile;
import com.webknot.UserService.Repository.MetroCardRepository;
import com.webknot.UserService.Repository.TravelHistoryRepository;
import com.webknot.UserService.Repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetroCardService {
    private final MetroCardRepository metroCardRepository;
    private final UserProfileRepository userRepository;
    private final TravelHistoryRepository travelRepository;

    public MetroCard buyMetroCard(MetroCardDto dto) {
        UserProfile user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (metroCardRepository.findByUserId(dto.getUserId()).isPresent()) {
            throw new RuntimeException("User already has a metro card");
        }

        MetroCard metroCard = MetroCard.builder()
                .cardNumber(UUID.randomUUID().toString())
                .balance(dto.getInitialBalance())
                .user(user)
                .build();

        return metroCardRepository.save(metroCard);
    }

    public String cancelMetroPass(Long userId) {
        MetroCard metroCard = metroCardRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Metro card not found for this user"));

        if (hasUsedMetroPass(userId)) {
            throw new RuntimeException("Cannot cancel a used metro pass");
        }

        metroCardRepository.delete(metroCard);
        return "Metro pass successfully cancelled for user ID: " + userId;
    }

    private boolean hasUsedMetroPass(Long userId) {
        return travelRepository.existsByUserId(userId);
    }
}

