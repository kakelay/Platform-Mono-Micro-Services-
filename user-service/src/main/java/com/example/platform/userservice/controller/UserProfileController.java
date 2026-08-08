package com.example.platform.userservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.userservice.dto.request.CreateUserProfileRequest;
import com.example.platform.userservice.dto.request.UpdateUserProfileRequest;
import com.example.platform.userservice.dto.response.UserProfileResponse;
import com.example.platform.userservice.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserProfileResponse>> create(@Valid @RequestBody CreateUserProfileRequest request) {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.createUserProfile(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserProfileResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.getUserProfile(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfileResponse>>> list() {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.listUserProfiles(), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserProfileResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateUserProfileRequest request) {
        return ResponseEntity.ok(ApiResponse.success(userProfileService.updateUserProfile(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
