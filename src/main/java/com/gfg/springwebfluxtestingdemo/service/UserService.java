package com.gfg.springwebfluxtestingdemo.service;

import com.gfg.springwebfluxtestingdemo.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface UserService {
    Mono<User> getUserById(String id);
    Flux<User> getAllUsers();
    Mono<Void> saveUser(User user);
}
