package com.trainologic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Person {
  @Id
  private String id;
  private String firstName;
  private String lastName;
}
