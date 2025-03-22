package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.DepartmentCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.request.DepartmentUpdateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.DepartmentCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import com.nbenliogludev.taskmanagementservice.service.DepartmentService;
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
@RequestMapping("/api/task-management/departments")
@Validated
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/v1")
    public ResponseEntity<RestResponse<DepartmentCreateResponseDTO>> createDepartment(@RequestBody DepartmentCreateRequestDTO depaptmentDto) {
        return ResponseEntity.ok(RestResponse.of(departmentService.createDepartment(depaptmentDto)));
    }

    @GetMapping("/v1")
    public ResponseEntity<RestResponse<List<DepartmentCreateResponseDTO>>> getAllDepartments() {
        return ResponseEntity.ok(RestResponse.of(departmentService.getAllDepartments()));
    }

    @PutMapping("/v1")
    public ResponseEntity<RestResponse<DepartmentCreateResponseDTO>> updateDepartment(@RequestBody DepartmentUpdateRequestDTO request) {
        return ResponseEntity.ok(RestResponse.of(departmentService.updateDepartment(request)));
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<RestResponse<Void>> deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
