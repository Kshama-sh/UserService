package com.webknot.UserService.Repository;

import com.webknot.UserService.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelHistoryRepository extends JpaRepository<TravelHistory, Long> {
    List<TravelHistory> findTop10ByUserIdOrderByTravelTimeDesc(Long userId);

    boolean existsByUserId(Long userId);
}
