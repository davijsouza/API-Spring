package br.com.udemy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.udemy.data.model.Person;
import br.com.udemy.data.transform.DozerConverter;
import br.com.udemy.data.vo.PersonVO;
import br.com.udemy.exception.ResourceNotFoundException;
import br.com.udemy.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;

	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public Page<PersonVO> findPersonByName(String firstName, Pageable pageable) {
		//Page<Person> page = repository.findPersonByName(firstName, pageable);
		return null; //page.map(this::convertToPersonVO);
	}
	
	public Page<PersonVO> findAll(Pageable pageable) {
		Page<Person> page = repository.findAll(pageable);
		return page.map(this::convertToPersonVO);
	}	
	
	private PersonVO convertToPersonVO(Person entity) {
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	
	public PersonVO findById(Long id) {

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}
