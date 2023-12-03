package org.example.services.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super("Could not find user with id: " + id);
    }

    public UserNotFoundException(String name) {
        super("Could not find user with name: " + name);
    }

    public UserNotFoundException() {
        super("Could not find user");
    }
}

