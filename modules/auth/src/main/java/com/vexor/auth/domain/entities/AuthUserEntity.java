package com.vexor.auth.domain.entities;

import com.vexor.auth.domain.enums.UserRole;
import com.vexor.persistencebase.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(
        name = "auth_user", uniqueConstraints = @UniqueConstraint(name = "uk_auth_users_email", columnNames = "email"),
        schema = "auth"
)
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserEntity extends BaseEntity {

    @Column(nullable = false, length = 320)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 200)
    private String lastName;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
