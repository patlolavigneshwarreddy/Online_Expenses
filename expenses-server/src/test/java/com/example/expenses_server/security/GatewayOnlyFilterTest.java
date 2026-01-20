package com.example.expenses_server.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import org.junit.jupiter.api.Test;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class GatewayOnlyFilterTest {

    @Test
    void doFilterInternal_allowsOpenPaths() throws Exception {
        GatewayOnlyFilter filter = new GatewayOnlyFilter();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);

        when(req.getRequestURI()).thenReturn("/swagger/index.html");

        filter.doFilterInternal(req, res, chain);

        verify(chain, times(1)).doFilter(req, res);
    }

    @Test
    void doFilterInternal_forbiddenWhenNoHeader() throws Exception {
        GatewayOnlyFilter filter = new GatewayOnlyFilter();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);

        when(req.getRequestURI()).thenReturn("/api/secure");
        when(req.getHeader("X-Internal-Gateway")).thenReturn(null);

        PrintWriter writer = mock(PrintWriter.class);
        when(res.getWriter()).thenReturn(writer);

        filter.doFilterInternal(req, res, chain);

        verify(res, times(1)).setStatus(403);
    }

    @Test
    void doFilterInternal_allowsWhenHeaderMatches() throws Exception {
        GatewayOnlyFilter filter = new GatewayOnlyFilter();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);

        when(req.getRequestURI()).thenReturn("/api/secure");
        when(req.getHeader("X-Internal-Gateway")).thenReturn("inventory-gateway");

        filter.doFilterInternal(req, res, chain);

        verify(chain, times(1)).doFilter(req, res);
    }
}
