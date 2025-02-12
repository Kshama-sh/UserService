package com.webknot.UserService.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String contact;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private MetroCard metroPass;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TravelHistory> travelHistory;
}
