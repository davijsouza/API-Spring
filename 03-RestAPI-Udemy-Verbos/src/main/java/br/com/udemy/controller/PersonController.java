package br.com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return personServices.findAll();
	}
	
	
	
	@RequestMapping(value= "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id) {
		return personServices.findById(id);
	}
	
	
	@RequestMapping(
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return personServices.create(person);
	}
	
	
	@RequestMapping(
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return personServices.update(person);
	}
	
	
	
	@RequestMapping(value= "/{id}",
			method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		personServices.delete(id);
	}
	
	

	
}
