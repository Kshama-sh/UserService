package com.webknot.UserService.Dto;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
@Builder
@Data
public class TravelHistoryDto {
    private Long id;
    private String source;
    private String destination;
    private Double fare;
    private LocalDateTime travelTime;
    private Long userId;
}
