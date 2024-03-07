package com.gfg.springwebfluxtestingdemo.service;

import com.gfg.springwebfluxtestingdemo.model.User;
import com.gfg.springwebfluxtestingdemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void getUserById() {
        User user = new User("1", "John", 30);
        when(userRepository.findById("1")).thenReturn(Mono.just(user));

        Mono<User> result = userService.getUserById("1");

        StepVerifier.create(result)
                .expectNext(user)
                .verifyComplete();
    }

    @Test
    void getAllUsers() {
        User user1 = new User("1", "John", 30);
        User user2 = new User("2", "Alice", 25);
        when(userRepository.findAll()).thenReturn(Flux.just(user1, user2));

        Flux<User> result = userService.getAllUsers();

        StepVerifier.create(result)
                .expectNext(user1)
                .expectNext(user2)
                .verifyComplete();
    }

    @Test
    void saveUser() {
        User user = new User("1", "John", 30);
        when(userRepository.save(user)).thenReturn(Mono.empty());

        Mono<Void> result = userService.saveUser(user);

        StepVerifier.create(result)
                .verifyComplete();
    }
}

