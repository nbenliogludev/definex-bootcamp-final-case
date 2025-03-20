package com.nbenliogludev.taskmanagementservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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
}
