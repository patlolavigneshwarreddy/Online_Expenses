package com.example.expenses_server.security;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FeignClientHeaderForwardInterceptorTest {

    @AfterEach
    void tearDown() {
        RequestContextHolder.resetRequestAttributes();
    }

    @Test
    void apply_forwardsHeadersWhenPresent() {
        FeignClientHeaderForwardInterceptor interceptor = new FeignClientHeaderForwardInterceptor();
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getHeader("X-Internal-Gateway")).thenReturn("inventory-gateway");
        when(req.getHeader("X-User-Id")).thenReturn("1");
        when(req.getHeader("X-User-Role")).thenReturn("ADMIN");

        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));

        RequestTemplate template = new RequestTemplate();
        interceptor.apply(template);

        assertThat(template.headers()).containsKeys("X-Internal-Gateway", "X-User-Id", "X-User-Role");
//        assertThat(template.header("X-User-Id")).contains("1");
    }

    @Test
    void apply_noRequestAttributes_doesNothing() {
        FeignClientHeaderForwardInterceptor interceptor = new FeignClientHeaderForwardInterceptor();
        RequestContextHolder.resetRequestAttributes();
        RequestTemplate template = new RequestTemplate();
        interceptor.apply(template);
        assertThat(template.headers()).isEmpty();
    }
}
