package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.ProjectCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.ProjectCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nbenliogludev
 */
@RestController
@RequestMapping("/api/task-management/projects")
@Validated
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/v1")
    public ResponseEntity<RestResponse<ProjectCreateResponseDTO>> createProject(@RequestBody ProjectCreateRequestDTO projectDto) {
        return ResponseEntity.ok(RestResponse.of(projectService.createProject(projectDto)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProjectCreateResponseDTO>>> getAllProjects() {
        return ResponseEntity.ok(RestResponse.of(projectService.getAllProjects()));
    }
}
