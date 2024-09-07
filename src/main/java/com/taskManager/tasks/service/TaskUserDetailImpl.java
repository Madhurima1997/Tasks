package com.taskManager.tasks.service;

import com.taskManager.tasks.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TaskUserDetailImpl implements ReactiveUserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.just(userDao.getUserByUsername(username))
                .map(user -> org.springframework.security.core.userdetails.User
                        .withUsername(user.getUsername())
                        .password(user.getPass())
                        .build())
                .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")));
    }
}
