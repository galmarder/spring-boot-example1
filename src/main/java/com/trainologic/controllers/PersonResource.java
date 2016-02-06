package com.trainologic.controllers;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.springframework.hateoas.Link;

@Data
public class PersonResource {
	
	private String id;
	private String firstName;
	private String lastName;
	private List<Link> links = new ArrayList<Link>();
	
	
	
	public void addLink(Link link){
		links.add(link);
	}

}
