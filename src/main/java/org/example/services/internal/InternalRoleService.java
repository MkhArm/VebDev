package org.example.services.internal;

import org.example.models.entities.UserRole;
import org.example.models.enums.UserRoleType;

public interface InternalRoleService {
    UserRole findByRole (UserRoleType roleType);
}

