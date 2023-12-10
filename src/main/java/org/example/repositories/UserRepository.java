package org.example.repositories;

import org.example.models.entities.User;
import org.example.models.entities.UserRole;
import org.example.models.enums.UserRoleType;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByRole_Role(UserRoleType roleType);
    Optional<User> findByUsername(String username);
}
