package com.trainologic.services;

import com.trainologic.dao.PersonRepository;
import com.trainologic.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonManagementService {
  @Autowired
  private PersonRepository personRepository;

  public List<Person> get() {
    List<Person> ret = new ArrayList<>();
    personRepository.findAll().forEach(person -> ret.add(person));
    return ret;
  }

  public Person getPersonById(String id) { return personRepository.findOne(id);}

  public Person addPerson(Person person) {
    String id = ""+System.currentTimeMillis();
    person.setId(id);
    personRepository.save(person);
    return person;
  }
}
