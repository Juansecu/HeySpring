package com.juansecu.HeySpring.daos;

import org.springframework.data.repository.CrudRepository;

import com.juansecu.HeySpring.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {
}
