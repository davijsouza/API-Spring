package br.com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.service.Operation;

@RestController
public class MathController{

	@Autowired
	private Operation operation;
	
	// http://localhost:8080/sum/?numberOne=valor?numberTow=valor
	
	/* 
	|==============================================================================
	|
    |   http://localhost:8080/sum/  ----   definindo paramentros de entrada
	|                                   
	|==============================================================================
	*/
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value="numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return operation.sum(numberOne, numberTwo);
		
	}
	
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value="numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return operation.subtraction(numberOne, numberTwo);
	}
	
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value="numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return operation.multiplication(numberOne, numberTwo);
	}
	
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable(value="numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return operation.division(numberOne, numberTwo);
	}
	
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable(value="numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		return operation.mean(numberOne, numberTwo);
	}
	
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable(value="number") String number) throws Exception {
		return operation.squareRoot(number);
	}
	
}
