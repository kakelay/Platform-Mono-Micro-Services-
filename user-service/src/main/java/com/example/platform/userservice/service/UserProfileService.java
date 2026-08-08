package com.example.platform.userservice.service;

import com.example.platform.userservice.dto.request.CreateUserProfileRequest;
import com.example.platform.userservice.dto.request.UpdateUserProfileRequest;
import com.example.platform.userservice.dto.response.UserProfileResponse;

import java.util.List;
import java.util.UUID;

public interface UserProfileService {
    UserProfileResponse createUserProfile(CreateUserProfileRequest request);
    UserProfileResponse getUserProfile(UUID id);
    List<UserProfileResponse> listUserProfiles();
    UserProfileResponse updateUserProfile(UUID id, UpdateUserProfileRequest request);
    void deleteUserProfile(UUID id);
}
