package com.juansecu.HeySpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juansecu.HeySpring.domain.Person;

import com.juansecu.HeySpring.daos.IPersonDao;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonDao personDao;

    @Override
    @Transactional
    public void deletePerson(Person person) {
        this.personDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getPeople() {
        return (List<Person>) this.personDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Person getPerson(long personId) {
        return this.personDao.findById(personId).orElse(null);
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        this.personDao.save(person);
    }
}
