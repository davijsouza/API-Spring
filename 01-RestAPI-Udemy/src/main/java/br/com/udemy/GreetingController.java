package br.com.udemy;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	
	private final AtomicLong atomicCounter = new AtomicLong();

	
	// http://localhost:8080/greeting?name=Udemy
	
	/* 
	|==============================================================================
	|
    |   http://localhost:8080/greeting  ----> inicializacao do mapeamento
	|
	|   ?name=   ------> informar o parametro caso não retornara o default = "Word"
	|   
	|==============================================================================
	*/
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue = "Word") String name) {
		return new Greeting(atomicCounter.incrementAndGet(), String.format(template, name));
	}
}
