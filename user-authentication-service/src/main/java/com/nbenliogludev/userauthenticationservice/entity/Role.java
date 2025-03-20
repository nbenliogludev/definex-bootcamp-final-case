package com.nbenliogludev.userauthenticationservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.nbenliogludev.userauthenticationservice.entity.Permission.*;

/**
 * @author nbenliogludev
 */
@RequiredArgsConstructor
public enum Role {

    GROUP_PROJECT_MANAGER(Set.of(

    )),

    PROJECT_MANAGER(Set.of(

    )),

    TEAM_LEADER(Set.of(

    )),

    TEAM_MEMBER(Set.of(

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
