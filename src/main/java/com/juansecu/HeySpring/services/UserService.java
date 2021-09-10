package com.juansecu.HeySpring.services;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juansecu.HeySpring.domain.User;

import com.juansecu.HeySpring.daos.IUserDao;

@Service("userDetailsService")
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException("User with username " + username + " was not found!");

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
