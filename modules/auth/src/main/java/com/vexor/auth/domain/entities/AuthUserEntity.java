package com.vexor.auth.domain.entities;

import com.vexor.auth.domain.enums.UserRole;
import com.vexor.persistencebase.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
    private  String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 200)
    private String lastName;

    @Column(nullable = false, length = 20)
    private UserRole role;
}
