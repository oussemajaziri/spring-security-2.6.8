package com.oj.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oj.springsecurity.domain.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

	Role findByName (String name);
}
