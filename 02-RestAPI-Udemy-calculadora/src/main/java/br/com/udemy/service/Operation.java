package br.com.udemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.udemy.exception.FaultOperationException;

@Component
public class Operation{
	
	@Autowired
	private MathService mathservice;

	public Double sum(String numberOne, String numberTwo) throws Exception {
		if (!mathservice.isNumeric(numberOne) || !mathservice.isNumeric(numberTwo)) {
			throw new FaultOperationException("Por favor defina um valor numérico.");
		}
		Double sum = (mathservice.convertoDouble(numberOne) + mathservice.convertoDouble(numberTwo));
		return sum;
	}

	
	public Double subtraction(String numberOne, String numberTwo) throws Exception {
		if (!mathservice.isNumeric(numberOne) || !mathservice.isNumeric(numberTwo)) {
			throw new FaultOperationException("Por favor defina um valor numérico.");
		}
		Double subtraction = (mathservice.convertoDouble(numberOne) - mathservice.convertoDouble(numberTwo));
		return subtraction;
	}

	
	public Double multiplication(String numberOne, String numberTwo) throws Exception {
		if (!mathservice.isNumeric(numberOne) || !mathservice.isNumeric(numberTwo)) {
			throw new FaultOperationException("Por favor defina um valor numérico.");
		}
		Double multiplication = (mathservice.convertoDouble(numberOne) + mathservice.convertoDouble(numberTwo));
		return multiplication;
	}

	
	public Double division(String numberOne, String numberTwo) throws Exception {
		if (!mathservice.isNumeric(numberOne) || !mathservice.isNumeric(numberTwo)) {
			throw new FaultOperationException("Por favor defina um valor numérico.");
		}
		Double division = (mathservice.convertoDouble(numberOne) + mathservice.convertoDouble(numberTwo));
		return division;
	}

	
	public Double mean(String numberOne, String numberTwo) throws Exception {
		if (!mathservice.isNumeric(numberOne) || !mathservice.isNumeric(numberTwo)) {
			throw new FaultOperationException("Por favor defina um valor numérico.");
		}
		Double mean = (mathservice.convertoDouble(numberOne) + mathservice.convertoDouble(numberTwo)) / 2;
		return mean;
	}

	
	public Double squareRoot(String number )throws Exception {
		if(!mathservice.isNumeric(number)) {
			throw new FaultOperationException("Por favor defina um valor numérico.");
		}
		Double squareRoot = Math.sqrt(mathservice.convertoDouble(number)) ;
		return squareRoot;
		}
}
