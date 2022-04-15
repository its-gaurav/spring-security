package demo.security.enums;

public enum UserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String description;

    UserPermission(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
