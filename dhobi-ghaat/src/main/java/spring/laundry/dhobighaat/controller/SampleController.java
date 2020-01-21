package spring.laundry.dhobighaat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/welcome")
	public String m1()
	{
		return "<h1>Hello World</h1>";
	}
}
