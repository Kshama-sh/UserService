package com.webknot.UserService.Repository;

import com.webknot.UserService.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetroPassRepository extends JpaRepository<MetroCard, Long> {
}
