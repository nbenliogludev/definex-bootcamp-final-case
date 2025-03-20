package com.nbenliogludev.userauthenticationservice.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nbenliogludev
 */
@Getter
@Setter
public class CheckPermissionRequestDTO {
    private String token;
    private String permission;
}
