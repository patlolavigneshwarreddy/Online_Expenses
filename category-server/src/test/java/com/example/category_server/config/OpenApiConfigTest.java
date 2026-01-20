package com.example.category_server.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenApiConfigTest {

    @Test
    void customOpenAPI_hasInfo() {
        OpenApiConfig cfg = new OpenApiConfig();
        OpenAPI api = cfg.customOpenAPI();
        assertNotNull(api);
        assertNotNull(api.getInfo());
        assertEquals("Category Service API", api.getInfo().getTitle());
    }
}
