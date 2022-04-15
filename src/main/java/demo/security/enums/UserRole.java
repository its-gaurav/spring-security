package demo.security.enums;

import jdk.nashorn.internal.ir.SetSplitState;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public enum UserRole {
    STUDENT(new HashSet<>()),
    ADMIN(new HashSet<>(Arrays.asList(UserPermission.COURSE_READ, UserPermission.COURSE_WRITE,
            UserPermission.STUDENT_READ, UserPermission.STUDENT_WRITE)));

    private final HashSet<UserPermission> permissions;

    UserRole(HashSet<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public HashSet<UserPermission> getPermissions() {
        return permissions;
    }
}
