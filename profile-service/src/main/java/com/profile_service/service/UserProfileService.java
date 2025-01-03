package com.profile_service.service;

import com.profile_service.dto.request.ProfileCreateRequest;
import com.profile_service.dto.response.ProfileCreateResponse;
import com.profile_service.entity.UserProfile;
import com.profile_service.repository.UserProfileRepository;
import com.profile_service.mapper.UserProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
        this.userProfileRepository = userProfileRepository;
        this.userProfileMapper = userProfileMapper;
    }

    public ProfileCreateResponse createUserProfile(ProfileCreateRequest userRequest) {
        UserProfile userProfile = userProfileMapper.toEntity(userRequest);
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toResponse(savedProfile);
    }

    public Optional<ProfileCreateResponse> getUserProfileById(String id) {
        return userProfileRepository.findById(id)
                .map(userProfileMapper::toResponse);
    }

    public ProfileCreateResponse getUserProfileByUserId(String userId) {
        UserProfile profile = userProfileRepository.findByUserId(userId);
        return profile != null ? userProfileMapper.toResponse(profile) : null;
    }

    public List<ProfileCreateResponse> getAllUserProfiles() {
        return userProfileRepository.findAll().stream()
                .map(userProfileMapper::toResponse)
                .toList();
    }

    public void deleteUserProfile(String id) {
        userProfileRepository.deleteById(id);
    }
}
