package org.example.services;

import jakarta.transaction.Transactional;
import org.example.models.entities.User;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.input.UserDTO;
import org.example.models.enums.UserRoleType;
import org.example.services.dtos.output.UserOutputDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    List<UserDTO> findUsersByRole(UserRoleType roleType);

    UserDTO getUserByUsername(String username);

    UserDTO getUserDTOById(String id);

    List<UserDTO> findAll();

    List<UserOutputDTO> getUserOutputDTO();

    UserOutputDTO getUserOutputDTOById(String id);

    User getUserById(String id);

    @Transactional
    UserDTO editUser(String id, UserDTO userDTO);

}


