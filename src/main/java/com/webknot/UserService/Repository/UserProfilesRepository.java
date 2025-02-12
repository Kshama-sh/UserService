package com.webknot.UserService.Repository;

import com.webknot.UserService.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfilesRepository extends JpaRepository<UserProfiles, Long> {
}
