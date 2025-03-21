package com.nbenliogludev.taskmanagementservice.service.impl;

import com.nbenliogludev.taskmanagementservice.dto.request.DepartmentCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.DepartmentCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.entity.Department;
import com.nbenliogludev.taskmanagementservice.mapper.DepartmentMapper;
import com.nbenliogludev.taskmanagementservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nbenliogludev
 */
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentCreateResponseDTO createDepartment(DepartmentCreateRequestDTO request) {
        Department department = new Department();
        department.setName(request.name());
        Department saved = departmentRepository.save(department);

        return new DepartmentCreateResponseDTO(saved.getId(), saved.getName());
    }

    @Override
    public List<DepartmentCreateResponseDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(departmentMapper::mapToDepartmentResponse)
                .toList();
    }
}