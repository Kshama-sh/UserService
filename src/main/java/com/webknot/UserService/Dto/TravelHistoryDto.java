package com.webknot.UserService.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelHistoryDto {
    private Long id;
    private String sourceStation;
    private String destinationStation;
    private Double fare;
    private LocalDateTime travelDate;
}
