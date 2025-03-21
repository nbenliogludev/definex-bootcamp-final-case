package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.DepartmentCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.DepartmentCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import com.nbenliogludev.taskmanagementservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<RestResponse<DepartmentCreateResponseDTO>> createDepartment(@RequestBody DepartmentCreateRequestDTO depaptmentDto) {
        return ResponseEntity.ok(RestResponse.of(departmentService.createDepartment(depaptmentDto)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<DepartmentCreateResponseDTO>>> getAllDepartments() {
        return ResponseEntity.ok(RestResponse.of(departmentService.getAllDepartments()));
    }

}
