package com.vexor.auth.domain.repository;

import com.vexor.auth.domain.entities.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthUserJpaRepository extends JpaRepository<AuthUserEntity, UUID> {
    AuthUserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
