package com.nbenliogludev.userauthenticationservice.entity;

import lombok.Getter;

/**
 * Permissions aligned with the Advanced Task Management requirements.
 */
@Getter
public enum Permission {

    // Project Permissions
    PROJECT_READ("project:read"),
    PROJECT_CREATE("project:create"),
    PROJECT_UPDATE("project:update"),
    PROJECT_DELETE("project:delete"),

    // Task Permissions
    TASK_READ("task:read"),
    TASK_CREATE("task:create"),
    TASK_UPDATE("task:update"),
    TASK_DELETE("task:delete"),

    // Department Permissions
    DEPARTMENT_READ("department:read"),
    DEPARTMENT_CREATE("department:create"),
    DEPARTMENT_UPDATE("department:update"),
    DEPARTMENT_DELETE("department:delete"),

    // Comment Permissions
    COMMENT_ADD("comment:add"),
    COMMENT_DELETE("comment:delete"),

    // Attachment Permissions
    ATTACHMENT_UPLOAD("attachment:upload"),
    ATTACHMENT_DELETE("attachment:delete");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
