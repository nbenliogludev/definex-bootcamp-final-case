package com.nbenliogludev.taskmanagementservice.service;

import com.nbenliogludev.taskmanagementservice.dto.request.ProjectCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.request.ProjectUpdateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.DepartmentCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.ProjectCreateResponseDTO;

import java.util.List;

/**
 * @author nbenliogludev
 */
public interface ProjectService {
    ProjectCreateResponseDTO createProject(ProjectCreateRequestDTO request);
    List<ProjectCreateResponseDTO> getAllProjects();
    ProjectCreateResponseDTO updateProject(ProjectUpdateRequestDTO request);
}
