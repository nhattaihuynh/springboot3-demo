package com.profile_service.mapper;

import org.mapstruct.Mapper;

import com.profile_service.dto.request.ProfileCreateRequest;
import com.profile_service.dto.response.ProfileCreateResponse;
import com.profile_service.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    
    UserProfile toEntity(ProfileCreateRequest request);
    
    ProfileCreateResponse toResponse(UserProfile userProfile);
}
