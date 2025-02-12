package com.webknot.UserService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "travel_history")
public class TravelHistory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceStation;
    private String destinationStation;
    private Double fare;
    private LocalDateTime travelDate;

    @ManyToOne
    private UserProfiles user;
}