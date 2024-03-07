package com.gfg.springwebfluxtestingdemo.service;

import com.gfg.springwebfluxtestingdemo.model.User;
import com.gfg.springwebfluxtestingdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<Void> saveUser(User user) {
        return userRepository.save(user);
    }
}
