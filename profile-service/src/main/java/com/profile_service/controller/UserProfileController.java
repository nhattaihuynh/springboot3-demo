package com.profile_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.profile_service.dto.request.ProfileCreateRequest;
import com.profile_service.dto.response.ProfileCreateResponse;
import com.profile_service.service.UserProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

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

    @PutMapping("/{id}")
    public ResponseEntity<ProfileCreateResponse> updateProfile(
            @PathVariable String id,
            @RequestBody ProfileCreateRequest request) {
        ProfileCreateResponse response = userProfileService.updateUserProfile(id, request);
        return response != null 
            ? ResponseEntity.ok(response)
            : ResponseEntity.notFound().build();
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
