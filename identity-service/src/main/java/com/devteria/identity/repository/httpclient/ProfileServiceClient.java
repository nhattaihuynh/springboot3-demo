package com.devteria.identity.repository.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devteria.identity.dto.client.ProfileCreateRequest;
import com.devteria.identity.dto.client.ProfileResponse;

@FeignClient(name = "profile-service", url = "${app.service.profile.url}")
public interface ProfileServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<ProfileResponse> getProfileById(@PathVariable("id") String id);

    @GetMapping("/user/{userId}")
    ResponseEntity<ProfileResponse> getProfileByUserId(@PathVariable("userId") String userId);

    @PostMapping
    ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileCreateRequest request);
}
