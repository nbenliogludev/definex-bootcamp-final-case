package com.nbenliogludev.filestorageservice.service;

import com.nbenliogludev.filestorageservice.entity.FileMetadata;
import com.nbenliogludev.filestorageservice.exception.FileNotFoundException;
import com.nbenliogludev.filestorageservice.exception.FileStorageException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author nbenliogludev
 */
@Service
public class FileStorageService {

    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
    private final Path deletedFilesLocation = Paths.get("uploads/deleted").toAbsolutePath().normalize();
    private final FileStorageRepository fileStorageRepository;
    private static final List<String> ALLOWED_FILE_EXTENSIONS = List.of("pdf", "png", "jpg", "jpeg");

    public FileStorageService(FileStorageRepository fileStorageRepository) throws IOException {
        this.fileStorageRepository = fileStorageRepository;
        Files.createDirectories(fileStorageLocation);
        Files.createDirectories(deletedFilesLocation);
    }

    public String storeFile(MultipartFile file, UUID taskId) {
        try {
            if (file.isEmpty()) {
                throw new FileStorageException("Uploaded file is empty.");
            }

            String originalFileName = file.getOriginalFilename();
            if (originalFileName == null || !isAllowedFileType(originalFileName)) {
                throw new FileStorageException("Unsupported file format. Allowed: " + ALLOWED_FILE_EXTENSIONS);
            }

            String fileName = UUID.randomUUID() + "_" + originalFileName;
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            FileMetadata fileMetadata = new FileMetadata();
            fileMetadata.setId(UUID.randomUUID());
            fileMetadata.setTaskId(taskId);
            fileMetadata.setFileName(fileName);
            fileMetadata.setFilePath(targetLocation.toString());
            fileMetadata.setUploadedAt(LocalDateTime.now());
            fileMetadata.setDeleted(false);

            fileStorageRepository.save(fileMetadata);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("File upload failed for: " + file.getOriginalFilename(), ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Optional<FileMetadata> metadataOpt = fileStorageRepository.findByFileNameAndDeletedFalse(fileName);
            if (metadataOpt.isEmpty()) {
                throw new FileNotFoundException(fileName);
            }

            Path filePath = Paths.get(metadataOpt.get().getFilePath()).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Cannot read file: " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileStorageException("Malformed file path for: " + fileName, ex);
        }
    }

    public void deleteFile(String fileName) {
        try {
            Optional<FileMetadata> metadataOpt = fileStorageRepository.findByFileNameAndDeletedFalse(fileName);
            if (metadataOpt.isEmpty()) {
                throw new FileNotFoundException(fileName);
            }

            FileMetadata fileMetadata = metadataOpt.get();
            Path filePath = Paths.get(fileMetadata.getFilePath());
            Path targetLocation = deletedFilesLocation.resolve(fileName);
            Files.move(filePath, targetLocation, StandardCopyOption.REPLACE_EXISTING);

            fileMetadata.setDeleted(true);
            fileMetadata.setFilePath(targetLocation.toString());
            fileStorageRepository.save(fileMetadata);
        } catch (IOException ex) {
            throw new FileStorageException("Failed to delete file: " + fileName, ex);
        }
    }

    private boolean isAllowedFileType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        return ALLOWED_FILE_EXTENSIONS.contains(fileExtension);
    }
}
