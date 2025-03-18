package com.nbenliogludev.userauthenticationservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.nbenliogludev.userauthenticationservice.entity.Permission.*;

@RequiredArgsConstructor
public enum Role {

    USER(Set.of(
            PROJECT_READ,
            TASK_READ,
            DEPARTMENT_READ,
            COMMENT_ADD,
            ATTACHMENT_UPLOAD
    )),

    MANAGER(Set.of(
            // All USER perms
            PROJECT_READ,
            TASK_READ,
            DEPARTMENT_READ,
            COMMENT_ADD,
            ATTACHMENT_UPLOAD,
            // Additional create/update perms
            PROJECT_CREATE,
            PROJECT_UPDATE,
            TASK_CREATE,
            TASK_UPDATE,
            DEPARTMENT_CREATE,
            DEPARTMENT_UPDATE
    )),

    ADMIN(Set.of(
            // Everything
            PROJECT_READ, PROJECT_CREATE, PROJECT_UPDATE, PROJECT_DELETE,
            TASK_READ, TASK_CREATE, TASK_UPDATE, TASK_DELETE,
            DEPARTMENT_READ, DEPARTMENT_CREATE, DEPARTMENT_UPDATE, DEPARTMENT_DELETE,
            COMMENT_ADD, COMMENT_DELETE,
            ATTACHMENT_UPLOAD, ATTACHMENT_DELETE
    ));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
