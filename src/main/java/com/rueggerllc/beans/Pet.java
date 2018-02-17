package com.rueggerllc.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="pet")
@NamedQueries
({
	@NamedQuery(name="pet.findAll",query="select p from Pet p"),
	@NamedQuery(name="pet.findByName",query="select p from CustomerOrder p where p.name=:p")
})
public class Pet {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private long id;
	
	@Column(name="species")
	private String species;
	
	@Column(name="color")
	private String color;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="name")
	private String name;
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pet.id: " + id);
		builder.append("\nPet.species: " + species);
		builder.append("\nPet.color: " + color);
		builder.append("\nPet.weight: " + weight);
		builder.append("\nPet.name: " + name);
		return builder.toString();
	}
	
	



}
