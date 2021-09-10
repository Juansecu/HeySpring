package com.juansecu.HeySpring.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juansecu.HeySpring.domain.User;

public interface IUserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
