package com.projectfacul.dev.repository;

import com.projectfacul.dev.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmailAndIsActive(String email, Boolean isActive);
    Optional<UserEntity> findByUsernameAndIsActive(String username,Boolean isActive);
}
