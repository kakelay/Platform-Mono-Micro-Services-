package com.example.platform.userservice.dto.response;

import java.util.UUID;

public class UserProfileResponse {

    private final UUID id;
    private final String authUserId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String status;
    private final String preferences;

    public UserProfileResponse(UUID id, String authUserId, String firstName, String lastName, String email, String status, String preferences) {
        this.id = id;
        this.authUserId = authUserId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.preferences = preferences;
    }

    public UUID getId() {
        return id;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getPreferences() {
        return preferences;
    }
}
