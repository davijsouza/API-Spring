package br.com.udemy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.data.model.Person;
import br.com.udemy.data.transform.DozerTransform;
import br.com.udemy.data.vo.PersonVO;
import br.com.udemy.exception.ResourceNotFoundException;
import br.com.udemy.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository personRepository;
	
	public PersonVO findById(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No recordes found for this ID"));
		
		return DozerTransform.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll() {
		return DozerTransform.parseListObject(personRepository.findAll(),PersonVO.class);
	}
	
	
	public PersonVO create(PersonVO person) {
		Person entity = DozerTransform.parseObject(person, Person.class);
		PersonVO vo = DozerTransform.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
	}
	
	
	public PersonVO update(PersonVO person) {
		Person entity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No recordes found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		PersonVO vo = DozerTransform.parseObject(personRepository.save(entity), PersonVO.class);
		
		return  vo;
	}
	
	
	public void delete(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No recordes found for this ID"));
		personRepository.delete(entity);
	}
}
