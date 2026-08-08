package com.example.platform.authservice.dto.response;

import java.util.Set;
import java.util.UUID;

public class UserResponse {

    private final UUID id;
    private final String username;
    private final String email;
    private final Set<String> roles;

    public UserResponse(UUID id, String username, String email, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
