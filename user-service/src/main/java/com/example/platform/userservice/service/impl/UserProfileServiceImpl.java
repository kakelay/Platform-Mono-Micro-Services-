package com.example.platform.userservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.userservice.dto.request.CreateUserProfileRequest;
import com.example.platform.userservice.dto.request.UpdateUserProfileRequest;
import com.example.platform.userservice.dto.response.UserProfileResponse;
import com.example.platform.userservice.entity.UserProfileEntity;
import com.example.platform.userservice.repository.UserProfileRepository;
import com.example.platform.userservice.service.UserProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserProfileResponse createUserProfile(CreateUserProfileRequest request) {
        var entity = new UserProfileEntity();
        entity.setAuthUserId(request.getAuthUserId());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setStatus(request.getStatus());
        entity.setPreferences(request.getPreferences());
        var saved = repository.save(entity);
        return toResponse(saved);
    }

    @Override
    public UserProfileResponse getUserProfile(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "User profile not found"));
    }

    @Override
    public List<UserProfileResponse> listUserProfiles() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public UserProfileResponse updateUserProfile(UUID id, UpdateUserProfileRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "User profile not found"));
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setStatus(request.getStatus());
        entity.setPreferences(request.getPreferences());
        return toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteUserProfile(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("USER_NOT_FOUND", "User profile not found");
        }
        repository.deleteById(id);
    }

    private UserProfileResponse toResponse(UserProfileEntity entity) {
        return new UserProfileResponse(entity.getId(), entity.getAuthUserId(), entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getStatus(), entity.getPreferences());
    }
}
