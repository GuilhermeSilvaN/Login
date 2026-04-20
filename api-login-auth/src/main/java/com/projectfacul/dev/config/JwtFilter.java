package com.projectfacul.dev.config;

import com.projectfacul.dev.service.JwtService;
import com.projectfacul.dev.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private UserService userService;

    public  JwtFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        //ignora login
        if(request.getServletPath().startsWith("/login")){
            filterChain.doFilter(request,response);
            return;
        }

        String header = request.getHeader("Authorization");

        if(header != null && header.startsWith("Bearer ")){
            String token = header.substring(7);


            try{
                String email = jwtService.extractUsername(token);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails user = userService.loadUserByUsername(email);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    user.getAuthorities()
                            );

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        filterChain.doFilter(request, response);

    }
}
