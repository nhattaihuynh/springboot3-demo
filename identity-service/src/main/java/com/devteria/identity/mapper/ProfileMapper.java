package com.devteria.identity.mapper;

import org.mapstruct.Mapper;

import com.devteria.identity.dto.client.ProfileCreateRequest;
import com.devteria.identity.dto.request.UserCreationRequest;
import com.devteria.identity.entity.User;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileCreateRequest toProfileCreateRequest(UserCreationRequest request);

    ProfileCreateRequest toProfileCreateRequest(User user);
}
