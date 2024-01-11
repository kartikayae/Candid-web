// package com.practice.candidpractice.config;

// import java.io.IOException;

// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.NonNull;
// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// public class JWTAuthenticationFilter extends OncePerRequestFilter {

// private JwtService jwtService;

// @Override
// protected void doFilterInternal(
// @NonNull HttpServletRequest request,
// @NonNull HttpServletResponse response,
// @NonNull FilterChain filterChain)
// throws ServletException, IOException {

// final String authHeader = request.getHeader(ALREADY_FILTERED_SUFFIX);
// final String jwt;
// final String userEmail;

// if (authHeader == null || !authHeader.startsWith("Bearer ")) {
// filterChain.doFilter(request, response);
// }

// jwt = authHeader.substring(7);

// userEmail = jwtService.extractUsername(jwt);

// String s;
// }
// }