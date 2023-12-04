package org.example.services;

import org.example.services.dtos.input.UserDTO;
import org.example.services.dtos.input.UserRoleDTO;

import java.util.List;
import java.util.UUID;

public interface UserRoleService {
    UserRoleDTO createUserRole(UserRoleDTO userRoleDTO);

    UserRoleDTO getUserRoleById(String id);;

    List<UserRoleDTO> getAllUserRoles();

    void deleteUserRole(String id);

    List<UserRoleDTO> findAll();
}

