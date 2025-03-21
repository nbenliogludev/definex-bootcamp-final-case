package com.nbenliogludev.taskmanagementservice.dto.request;

import com.nbenliogludev.taskmanagementservice.enums.ProjectStatus;

import java.util.Set;
import java.util.UUID;

/**
 * @author nbenliogludev
 */
public record ProjectCreateRequestDTO(
        String title,
        String description,
        ProjectStatus status,
        UUID departmentId,
        Set<UUID> teamMemberIds
) {
}
