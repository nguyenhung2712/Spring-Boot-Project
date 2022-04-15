package com.nguyenhung.ls.repository;

import org.springframework.data.repository.CrudRepository;

import com.nguyenhung.ls.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByName(String name);

}