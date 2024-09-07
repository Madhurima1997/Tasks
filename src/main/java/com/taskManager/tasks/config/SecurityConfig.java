package com.taskManager.tasks.config;

import com.taskManager.tasks.service.TaskUserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final TaskUserDetailImpl userDetailsService;
    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public SecurityConfig(TaskUserDetailImpl userDetailsService, CustomAuthenticationProvider customAuthenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.customAuthenticationProvider = customAuthenticationProvider;
    }


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http
                .authorizeExchange(authorize ->
                        authorize.pathMatchers("/users/register")
                                .permitAll()
                                .anyExchange()
                                .authenticated()
                );
        http.csrf(csrf-> csrf.disable());
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(customAuthenticationProvider);

        http.addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION);

        return http.build();
    }
}
