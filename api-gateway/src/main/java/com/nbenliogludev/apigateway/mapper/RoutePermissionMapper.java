package com.nbenliogludev.apigateway.mapper;

import org.springframework.http.HttpMethod;

import java.util.Map;

public class RoutePermissionMapper {

    private static final Map<String, String> ROUTE_PERMISSIONS = Map.ofEntries(
            Map.entry("POST_/api/files/v1/upload", "attachment:create"),
            Map.entry("GET_/api/files", "attachment:read"),
            Map.entry("POST_/api/projects", "project:create")
    );

    public static String getRequiredPermission(HttpMethod method, String path) {
        String key = method.name() + "_" + path;
        return ROUTE_PERMISSIONS.get(key);
    }
}
