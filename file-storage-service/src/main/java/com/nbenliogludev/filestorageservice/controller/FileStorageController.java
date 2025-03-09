package com.nbenliogludev.filestorageservice.controller;

import com.nbenliogludev.filestorageservice.dto.request.FileUploadRequestDTO;
import com.nbenliogludev.filestorageservice.dto.response.FileUploadResponseDTO;
import com.nbenliogludev.filestorageservice.dto.response.RestResponse;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author nbenliogludev
 */
@RestController
@RequestMapping("/api/files")
@Validated
public class FileStorageController {

    private final FileStorageService fileStorageService;

    @PostMapping("v1/upload")
    public ResponseEntity<RestResponse<FileUploadResponseDTO>> uploadFile(
            @RequestBody @Valid FileUploadRequestDTO request) throws IOException {

        String storedFileName = fileStorageService.storeFile(request.file(), request.taskId());
        String fileUrl = "/api/files/download/" + storedFileName;

        FileUploadResponseDTO responseDTO = new FileUploadResponseDTO(storedFileName, fileUrl);

        return ResponseEntity.ok(RestResponse.of(responseDTO));
    }

    @GetMapping("v1/download/{fileName}/v1")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("v1/delete/{fileName}")
    public ResponseEntity<RestResponse<String>> deleteFile(@PathVariable String fileName) {
        fileStorageService.deleteFile(fileName);
        return ResponseEntity.ok(RestResponse.of("File marked as deleted: " + fileName));
    }
}
