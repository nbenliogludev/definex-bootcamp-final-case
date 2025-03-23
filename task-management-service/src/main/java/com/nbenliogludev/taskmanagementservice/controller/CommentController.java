package com.nbenliogludev.taskmanagementservice.controller;

import com.nbenliogludev.taskmanagementservice.dto.request.CommentCreateRequestDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.CommentCreateResponseDTO;
import com.nbenliogludev.taskmanagementservice.dto.response.RestResponse;
import com.nbenliogludev.taskmanagementservice.service.CommentService;
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
@RequestMapping("/api/task-management/comments")
@Validated
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/v1")
    public ResponseEntity<RestResponse<CommentCreateResponseDTO>> createComment(@RequestBody CommentCreateRequestDTO commentDto) {
        return ResponseEntity.ok(RestResponse.of(commentService.createComment(commentDto)));
    }

    @GetMapping("/v1/task/{taskId}")
    public ResponseEntity<RestResponse<List<CommentCreateResponseDTO>>> getCommentsByTaskId(@PathVariable UUID taskId) {
        return ResponseEntity.ok(RestResponse.of(commentService.getCommentsByTaskId(taskId)));
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<RestResponse<Void>> deleteComment(@PathVariable UUID id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
