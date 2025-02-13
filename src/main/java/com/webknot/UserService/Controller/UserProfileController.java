package com.webknot.UserService.Controller;

import com.webknot.UserService.Dto.UserProfilesDto;
import com.webknot.UserService.Entity.*;
import com.webknot.UserService.Service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/add")
    public ResponseEntity<UserProfile> addUser(@Valid @RequestBody UserProfilesDto user) {
        return ResponseEntity.ok(userProfileService.addUser(user));
    }

    @GetMapping("/get")
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllUsers() {
        userProfileService.deleteAllUsers();
        return ResponseEntity.ok("All users deleted successfully");
    }
}
