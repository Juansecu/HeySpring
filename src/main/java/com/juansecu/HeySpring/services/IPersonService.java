package com.juansecu.HeySpring.services;

import java.util.List;

import com.juansecu.HeySpring.domain.Person;

public interface IPersonService {
    public void deletePerson(Person person);

    public List<Person> getPeople();

    public Person getPerson(long personId);

    public void savePerson(Person person);
}
