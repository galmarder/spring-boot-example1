package com.trainologic.controllers;

import com.trainologic.exceptions.EntityNotFound;
import com.trainologic.model.Person;
import com.trainologic.services.PersonManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Controller
@RequestMapping("/people")
public class PersonController {
	@Autowired
	PersonManagementService personManagementService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<PersonResource> addPerson(@RequestBody Person person) {
		person = personManagementService.addPerson(person);
		PersonResource resource = personToResource(person);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(URI.create(resource.getLinks().get(0).getHref()));
		ResponseEntity<PersonResource> entity = new ResponseEntity<>(resource,
				headers, HttpStatus.CREATED);
		return entity;
	}
	
	
//	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	Person simpleaddPerson(@RequestBody Person person) {
		person = personManagementService.addPerson(person);
		return person;
	}

//	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	List<Person> list() {
		return personManagementService.get();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	List<PersonResource> listResources() {
		
		return personManagementService.get().stream()
				.map(person -> personToResource(person)).collect(Collectors.toList());
	}
	
	
	

	private PersonResource personToResource(Person person) {
		Link self = linkTo(getClass()).slash(person.getId()).withSelfRel();
		PersonResource resource = new PersonResource();
		resource.setId(person.getId());
		resource.setFirstName(person.getFirstName());
		resource.setLastName(person.getLastName());
		resource.addLink(self);
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	PersonResource getPerson(@PathVariable String id) {
		Person ret = personManagementService.getPersonById(id);
		if (ret == null)
			throw new EntityNotFound("person");
		return personToResource(ret);
	}

}
