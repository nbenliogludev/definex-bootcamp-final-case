package com.nbenliogludev.filestorageservice.dto.response;

/**
 * @author nbenliogludev
 */
public record FileUploadResponseDTO(
        String fileName,
        String fileUrl
) {}