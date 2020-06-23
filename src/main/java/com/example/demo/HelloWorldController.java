package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Greeting sayHello(@RequestParam(value="name") String name) {
		System.out.println("Got into Greeting sayHello()");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
