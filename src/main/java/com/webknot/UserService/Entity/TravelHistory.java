package com.webknot.UserService.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.ConnectionBuilder;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "travel_history")
public class TravelHistory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_station")
    private String source;
    private String destination;
    private Double fare;
    private LocalDateTime travelTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserProfile user;
}