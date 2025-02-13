package com.webknot.UserService.Service;

import com.webknot.UserService.Dto.TravelHistoryDto;
import com.webknot.UserService.Entity.TravelHistory;
import com.webknot.UserService.Entity.UserProfile;
import com.webknot.UserService.Repository.TravelHistoryRepository;
import com.webknot.UserService.Repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelHistoryService {

    private final TravelHistoryRepository travelHistoryRepository;
    private final UserProfileRepository userRepository;

    public TravelHistoryDto addTravelHistory(TravelHistoryDto dto) {
        UserProfile user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TravelHistory travelHistory = TravelHistory.builder()
                .user(user)
                .source(dto.getSource())
                .destination(dto.getDestination())
                .fare(dto.getFare())
                .travelTime(LocalDateTime.now())
                .build();

        TravelHistory savedHistory = travelHistoryRepository.save(travelHistory);

        return mapToDto(savedHistory);
    }

    public List<TravelHistoryDto> getLast10Trips(Long userId) {
        return travelHistoryRepository.findTop10ByUserIdOrderByTravelTimeDesc(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private TravelHistoryDto mapToDto(TravelHistory travelHistory) {
        return TravelHistoryDto.builder()
                .id(travelHistory.getId())
                .userId(travelHistory.getUser().getId())
                .source(travelHistory.getSource())
                .destination(travelHistory.getDestination())
                .fare(travelHistory.getFare())
                .travelTime(travelHistory.getTravelTime())
                .build();
    }
}
