package com.taskManager.tasks.config;

import com.taskManager.tasks.service.TaskUserDetailImpl;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomAuthenticationProvider implements ReactiveAuthenticationManager {

    private final TaskUserDetailImpl userDetailsService;

    public CustomAuthenticationProvider(TaskUserDetailImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication)
            throws AuthenticationException {
        return userDetailsService.findByUsername(authentication.getName())
                .filter(userDetails -> userDetails.getPassword().equals(authentication.getCredentials()))
                .map(userDetails -> new UsernamePasswordAuthenticationToken(
                        userDetails, userDetails.getPassword(), userDetails.getAuthorities()));
    }
}
