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
import java.util.UUID;

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

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<RestResponse<Void>> deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PatchMapping("/v1/{projectId}/members/add")
    public ResponseEntity<Void> addMemberToProject(@PathVariable UUID projectId, @RequestParam UUID memberId) {
        projectService.addMember(projectId, memberId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/v1/{projectId}/members/remove")
    public ResponseEntity<Void> removeMemberFromProject(@PathVariable UUID projectId, @RequestParam UUID memberId) {
        projectService.removeMember(projectId, memberId);
        return ResponseEntity.ok().build();
    }

}
