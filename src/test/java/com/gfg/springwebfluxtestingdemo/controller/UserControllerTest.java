package com.gfg.springwebfluxtestingdemo.controller;


import com.gfg.springwebfluxtestingdemo.model.User;
import com.gfg.springwebfluxtestingdemo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {
    private WebTestClient webTestClient;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        webTestClient = WebTestClient.bindToController(new UserController(userService)).build();
    }

    @Test
    void getUserById() {
        User user = new User("1", "John", 30);
        when(userService.getUserById("1")).thenReturn(Mono.just(user));

        webTestClient.get().uri("/users/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class).isEqualTo(user);
    }

    @Test
    void getAllUsers() {
        User user1 = new User("1", "John", 30);
        User user2 = new User("2", "Alice", 25);
        when(userService.getAllUsers()).thenReturn(Flux.just(user1, user2));

        webTestClient.get().uri("/users")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class).contains(user1, user2);
    }

    @Test
    void saveUser() {
        User user = new User("1", "John", 30);
        when(userService.saveUser(user)).thenReturn(Mono.empty());

        webTestClient.post().uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .expectStatus().isCreated();
    }
}

