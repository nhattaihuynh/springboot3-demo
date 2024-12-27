package com.profile_service.controller;

import java.util.List;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.profile_service.dto.request.ProfileCreateRequest;
import com.profile_service.dto.response.ProfileCreateResponse;
import com.profile_service.service.UserProfileService;


@RequestMapping("/api/v1")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<ProfileCreateResponse> createProfile(@RequestBody ProfileCreateRequest request) {
        ProfileCreateResponse response = userProfileService.createUserProfile(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileCreateResponse> getProfileById(@PathVariable String id) {
        return userProfileService.getUserProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ProfileCreateResponse> getProfileByUserId(@PathVariable String userId) {
        ProfileCreateResponse response = userProfileService.getUserProfileByUserId(userId);
        return response != null 
            ? ResponseEntity.ok(response)
            : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ProfileCreateResponse>> getAllProfiles() {
        List<ProfileCreateResponse> responses = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable String id) {
        if (userProfileService.getUserProfileById(id).isPresent()) {
            userProfileService.deleteUserProfile(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
