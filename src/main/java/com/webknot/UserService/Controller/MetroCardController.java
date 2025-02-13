package com.webknot.UserService.Controller;

import com.webknot.UserService.Dto.MetroCardDto;
import com.webknot.UserService.Entity.MetroCard;
import com.webknot.UserService.Service.MetroCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/metro-card")
@RequiredArgsConstructor
public class MetroCardController {
    private final MetroCardService metroCardService;

    @PostMapping("/buy-metro-card")
    public ResponseEntity<MetroCard> buyMetroCard(@RequestBody MetroCardDto dto) {
        return ResponseEntity.ok(metroCardService.buyMetroCard(dto));
    }

    @DeleteMapping("/cancel/{userId}")
    public ResponseEntity<?> cancelMetroPass(@PathVariable Long userId) {
        try {
            String message = metroCardService.cancelMetroPass(userId);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

