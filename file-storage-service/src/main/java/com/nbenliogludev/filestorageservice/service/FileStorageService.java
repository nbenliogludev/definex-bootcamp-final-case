package com.nbenliogludev.filestorageservice.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface FileStorageService {

    String storeFile(MultipartFile file, UUID taskId);

    Resource loadFileAsResource(String fileName);

    void deleteFile(String fileName);
}
