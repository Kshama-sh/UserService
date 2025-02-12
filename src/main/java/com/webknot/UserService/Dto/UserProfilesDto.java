package com.webknot.UserService.Dto;

import lombok.Data;

import java.util.*;

@Data
public class UserProfilesDto {
    private Long id;
    private String name;
    private String email;
    private String contact;
    private MetroCardDto metroPass;
    private List<TravelHistoryDto> travelHistory;
}
