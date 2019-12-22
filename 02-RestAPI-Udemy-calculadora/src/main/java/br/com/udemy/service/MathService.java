package br.com.udemy.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	
	
	public Double convertoDouble(String number) {
		if(number == null)
			return 0D;
		String n = number.replace(",", ".");
		if(isNumeric(number))
			return Double.parseDouble(n);
		return 0D;
	}

	public boolean isNumeric(String number) {
		if(number == null)
			return false;
		String n = number.replace(",", ".");
		return n.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
