package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.ProjectCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.request.ProjectUpdateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.ProjectCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import com.nbenliogludev.taskmanagementservice.service.ProjectService;
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

    @GetMapping("/v1")
    public ResponseEntity<RestResponse<List<ProjectCreateResponseDTO>>> getAllProjects() {
        return ResponseEntity.ok(RestResponse.of(projectService.getAllProjects()));
    }

    @PutMapping("/v1")
    public ResponseEntity<RestResponse<ProjectCreateResponseDTO>> updateProject(
            @RequestBody ProjectUpdateRequestDTO request) {
        return ResponseEntity.ok(RestResponse.of(projectService.updateProject(request)));
    }
}
