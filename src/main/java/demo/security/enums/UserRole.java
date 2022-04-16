package demo.security.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

import static demo.security.enums.UserPermission.*;

public enum UserRole {
    STUDENT(new HashSet<>()),
    ADMIN(new HashSet<>(Arrays.asList(COURSE_READ, COURSE_WRITE,
            STUDENT_READ, STUDENT_WRITE))),
    ADMINTRAINEE(new HashSet<>(Arrays.asList(COURSE_READ,
            STUDENT_READ)));

    private final HashSet<UserPermission> permissions;

    UserRole(HashSet<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public HashSet<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> authorities = getPermissions()
                .stream().map(permission ->
                        new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
