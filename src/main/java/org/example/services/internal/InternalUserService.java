package org.example.services.internal;

import org.example.models.entities.User;

import java.util.UUID;

public interface InternalUserService {
    User getUserById(String userId);

}
