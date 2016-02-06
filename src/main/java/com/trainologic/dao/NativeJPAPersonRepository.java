package com.trainologic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.trainologic.model.Person;

@Repository
public class NativeJPAPersonRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Person> getAll() {
		return em.createQuery("select p from Person p", Person.class).getResultList();
	}

}
