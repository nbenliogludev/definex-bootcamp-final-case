package com.nbenliogludev.taskmanagementservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<RestResponse<TaskCreateRequestDTO>> createTask(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(RestResponse.of(taskService.createTask(taskDto)));
    }

}
