package com.oj.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oj.springsecurity.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername (String username);
}
