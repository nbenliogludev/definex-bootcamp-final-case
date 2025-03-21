package com.nbenliogludev.taskmanagementservice.service;

import com.nbenliogludev.taskmanagementservice.dto.request.DepartmentCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.DepartmentCreateResponseDTO;

import java.util.List;

/**
 * @author nbenliogludev
 */
public interface DepartmentService {
    DepartmentCreateResponseDTO createDepartment(DepartmentCreateRequestDTO request);
    List<DepartmentCreateResponseDTO> getAllDepartments();
}
