package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.TaskCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.request.TaskUpdateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import com.nbenliogludev.taskmanagementservice.dto.response.TaskCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author nbenliogludev
 */
@Tag(name = "Task Controller", description = "Manage tasks")
@RestController
@RequestMapping("/api/task-management/tasks")
@Validated
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Create a new task")
    @PostMapping("/v1")
    public ResponseEntity<RestResponse<TaskCreateResponseDTO>> createTask(@RequestBody TaskCreateRequestDTO taskDto) {
        return ResponseEntity.ok(RestResponse.of(taskService.createTask(taskDto)));
    }

    @Operation(summary = "Update an existing task")
    @PutMapping("/v1")
    public ResponseEntity<RestResponse<TaskCreateResponseDTO>> updateTask(@RequestBody TaskUpdateRequestDTO taskDto) {
        return ResponseEntity.ok(RestResponse.of(taskService.updateTask(taskDto.id(), taskDto)));
    }

    @Operation(summary = "Get all tasks by project ID")
    @GetMapping("/v1/project/{projectId}")
    public ResponseEntity<RestResponse<List<TaskCreateResponseDTO>>> getAllByProjectId(@PathVariable UUID projectId) {
        return ResponseEntity.ok(RestResponse.of(taskService.getAllByProjectId(projectId)));
    }

    @Operation(summary = "Get all tasks by assignee ID")
    @GetMapping("/v1/assignee/{assigneeId}")
    public ResponseEntity<RestResponse<List<TaskCreateResponseDTO>>> getAllByAssigneeId(@PathVariable UUID assigneeId) {
        return ResponseEntity.ok(RestResponse.of(taskService.getAllByAssigneeId(assigneeId)));
    }

    @Operation(summary = "Delete a task by ID")
    @DeleteMapping("/v1/{id}")
    public ResponseEntity<RestResponse<Void>> deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
