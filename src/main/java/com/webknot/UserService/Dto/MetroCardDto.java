package com.webknot.UserService.Dto;

import lombok.Data;
import lombok.Getter;

@Data
public class MetroCardDto {
    private Long id;
    private String cardNumber;
    private Double balance;
    @Getter
    private Long userId;
    @Getter
    private Double initialBalance;

}
