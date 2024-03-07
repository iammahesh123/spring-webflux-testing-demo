package com.gfg.springwebfluxtestingdemo.repository;

import com.gfg.springwebfluxtestingdemo.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,String> {
    Mono<User> findById(String id);
    Flux<User> findAll();
    Mono<Void> save(User user);
}
