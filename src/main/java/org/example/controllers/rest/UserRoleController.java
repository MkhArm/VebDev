package org.example.controllers.rest;

import jakarta.validation.Valid;
import org.example.services.dtos.input.UserRoleDTO;
import org.example.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private UserRoleService userRoleService;

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<UserRoleDTO> createUserRole(@RequestBody @Valid UserRoleDTO userRoleDTO) {
        UserRoleDTO createdUserRole = userRoleService.createUserRole(userRoleDTO);
        return new ResponseEntity<>(createdUserRole, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getUserRoleById(@PathVariable String id) {
        UserRoleDTO userRoleDTO = userRoleService.getUserRoleById(id);
        return ResponseEntity.ok(userRoleDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserRoleDTO>> getAllUserRoles() {
        List<UserRoleDTO> userRoles = userRoleService.getAllUserRoles();
        return ResponseEntity.ok(userRoles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable String id) {
        userRoleService.deleteUserRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
