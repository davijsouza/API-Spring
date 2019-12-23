package br.com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.model.Person;
import br.com.udemy.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController{

	@Autowired
	private PersonServices personServices;
	
	// http://localhost:8080/person/?id=valor
	
	/* 
	|==============================================================================
	|
    |   http://localhost:8080/person/  ----   Paramentros de entrada
	|                                   
	|==============================================================================
	*/
	
	@GetMapping
	public List<Person> findAll() {
		return personServices.findAll();
	}
	
	
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return personServices.findById(id);
	}
	
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return personServices.create(person);
	}
	
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		return personServices.update(person);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		personServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
	

	
}
