package com.juansecu.HeySpring.services;

import java.util.List;

import com.juansecu.HeySpring.Person;

public interface IPersonService {
    public void deletePerson(Person personId);

    public List<Person> getPeople();

    public Person getPerson(long personId);

    public void savePerson(Person person);
}
