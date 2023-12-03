package org.example.models.enums;

public enum UserRoleType {
    USER(1),
    ADMIN(2);

    private final int userRoleTypeCode;

    private UserRoleType(int userRoleTypeCode) {
        this.userRoleTypeCode = userRoleTypeCode;
    }

    public int getUserRoleTypeCode() {
        return userRoleTypeCode;
    }
}

