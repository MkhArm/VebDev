package org.example.services;

import org.example.services.dtos.input.UserRoleDTO;
import java.util.List;

public interface UserRoleService {
    UserRoleDTO createUserRole(UserRoleDTO userRoleDTO);

    UserRoleDTO getUserRoleById(String id);;

    List<UserRoleDTO> getAllUserRoles();

    void deleteUserRole(String id);

    List<UserRoleDTO> findAll();
}

