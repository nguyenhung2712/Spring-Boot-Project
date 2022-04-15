package com.nguyenhung.ls.repository;

import org.springframework.data.repository.CrudRepository;

import com.nguyenhung.ls.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

}