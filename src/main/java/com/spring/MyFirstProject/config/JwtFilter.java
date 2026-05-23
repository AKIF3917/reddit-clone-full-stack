package com.spring.MyFirstProject.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final String SECRET_KEY =
            "myverystrongsecretkeyforjwtsecurity123456";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if (
                path.equals("/api/users/login") ||
                        path.equals("/api/users/register") ||
                        path.equals("/api/posts/all")
        ) {

            filterChain.doFilter(request, response);

            return;
        }
        String authHeader =
                request.getHeader("Authorization");

        // If token missing
        if(authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Invalid Token"
            );

            return;
        }

        String token = authHeader.substring(7);

        try {

            Claims claims = Jwts.parser()

                    .setSigningKey(SECRET_KEY.getBytes())

                    .parseClaimsJws(token)

                    .getBody();

            System.out.println(claims.getSubject());

        } catch (Exception e) {

            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Token Expired or Invalid"
            );

            return;
        }

        filterChain.doFilter(request, response);
    }
}