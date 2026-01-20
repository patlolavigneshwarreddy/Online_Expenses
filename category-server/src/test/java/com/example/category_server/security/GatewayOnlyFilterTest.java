package com.example.category_server.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GatewayOnlyFilterTest {

    private GatewayOnlyFilter filter;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain chain;

    @BeforeEach
    void setUp() throws IOException {
        filter = new GatewayOnlyFilter();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        chain = mock(FilterChain.class);

        // stub response writer
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);
    }

    @Test
    void allowsOpenApiPaths_withoutHeader() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn("/v3/api-docs");

        filter.doFilterInternal(request, response, chain);

        verify(chain).doFilter(request, response);
        verify(response, never()).setStatus(anyInt());
    }

    @Test
    void forbidsDirectAccess_withoutHeader() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn("/category/1");
        when(request.getHeader("X-Internal-Gateway")).thenReturn(null);

        filter.doFilterInternal(request, response, chain);

        verify(response).setStatus(403);
        verify(response).getWriter();
        verify(chain, never()).doFilter(request, response);
    }

    @Test
    void allowsWhenHeaderMatches() throws ServletException, IOException {
        when(request.getRequestURI()).thenReturn("/category/1");
        when(request.getHeader("X-Internal-Gateway")).thenReturn("inventory-gateway");

        filter.doFilterInternal(request, response, chain);

        verify(chain).doFilter(request, response);
        verify(response, never()).setStatus(403);
    }
}
