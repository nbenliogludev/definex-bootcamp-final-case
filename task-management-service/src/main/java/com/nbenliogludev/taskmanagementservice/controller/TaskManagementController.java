package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.TaskCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.request.TaskUpdateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import com.nbenliogludev.taskmanagementservice.dto.response.TaskCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.service.TaskService;
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
@RequestMapping("/api/tasks")
@Validated
@RequiredArgsConstructor
public class TaskManagementController {

    private final TaskService taskService;

    @PostMapping("/v1")
    public ResponseEntity<RestResponse<TaskCreateResponseDTO>> createTask(@RequestBody TaskCreateRequestDTO taskDto) {
        return ResponseEntity.ok(RestResponse.of(taskService.createTask(taskDto)));
    }

    @PutMapping("/v1/{id}")
    public ResponseEntity<RestResponse<TaskCreateResponseDTO>> updateTask(
            @PathVariable UUID id,
            @RequestBody TaskUpdateRequestDTO taskDto) {
        return ResponseEntity.ok(RestResponse.of(taskService.updateTask(id, taskDto)));
    }

    @GetMapping("/v1/project/{projectId}")
    public ResponseEntity<RestResponse<List<TaskCreateResponseDTO>>> getAllByProjectId(@PathVariable UUID projectId) {
        return ResponseEntity.ok(RestResponse.of(taskService.getAllByProjectId(projectId)));
    }

    @GetMapping("/v1/assignee/{assigneeId}")
    public ResponseEntity<RestResponse<List<TaskCreateResponseDTO>>> getAllByAssigneeId(@PathVariable UUID assigneeId) {
        return ResponseEntity.ok(RestResponse.of(taskService.getAllByAssigneeId(assigneeId)));
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<RestResponse<Void>> deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
