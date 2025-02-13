package com.webknot.UserService.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.*;

@Data
public class UserProfilesDto {
    private Long id;
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Contact number cannot be blank")
    private String contact;
//    private MetroCardDto metroPass;
//    private List<TravelHistoryDto> travelHistory;
}
