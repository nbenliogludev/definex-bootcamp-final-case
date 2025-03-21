package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.DepartmentCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.DepartmentCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nbenliogludev
 */
@RestController
@RequestMapping("/api/task-management/departments")
@Validated
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/v1")
    public ResponseEntity<RestResponse<DepartmentCreateResponseDTO>> createTask(@RequestBody DepartmentCreateRequestDTO depaptmentDto) {
        return ResponseEntity.ok(RestResponse.of(departmentService.createDepartment(depaptmentDto)));
    }

}
