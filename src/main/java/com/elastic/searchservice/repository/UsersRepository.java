package com.elastic.searchservice.repository;

import com.elastic.searchservice.model.User;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;



public interface UsersRepository extends CrudRepository<User, String> {
    @NonNull Iterable<User> findAll();
}

