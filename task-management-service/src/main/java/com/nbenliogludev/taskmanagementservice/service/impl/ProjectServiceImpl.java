package com.nbenliogludev.taskmanagementservice.service.impl;

import com.nbenliogludev.taskmanagementservice.dto.request.ProjectCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.ProjectCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.entity.Project;
import com.nbenliogludev.taskmanagementservice.repository.ProjectRepository;
import com.nbenliogludev.taskmanagementservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nbenliogludev
 */
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectCreateResponseDTO createProject(ProjectCreateRequestDTO request) {
        Project project = new Project();
        project.setName(request.name());
        Project saved = projectRepository.save(project);

        return new ProjectCreateResponseDTO(saved.getId(), saved.getName());
    }

    @Override
    public List<ProjectCreateResponseDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(projectMapper::mapToProjectResponse)
                .toList();
    }
}