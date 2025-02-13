package com.webknot.UserService.Controller;

import com.webknot.UserService.Dto.TravelHistoryDto;
import com.webknot.UserService.Service.TravelHistoryService;
import com.webknot.UserService.Service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travel-history")
@RequiredArgsConstructor
public class TravelHistoryController {

    private final TravelHistoryService travelHistoryService;
    private final UserProfileService userProfileService;

    @PostMapping("/add")
    public ResponseEntity<TravelHistoryDto> addTravelHistory(@RequestBody TravelHistoryDto travelHistoryDto) {
        return ResponseEntity.ok(travelHistoryService.addTravelHistory(travelHistoryDto));
    }

    @GetMapping("/{userID}/get")
    public ResponseEntity<List<TravelHistoryDto>> getLast10Trips(@PathVariable Long userId) {
        return ResponseEntity.ok(travelHistoryService.getLast10Trips(userId));
    }
}
