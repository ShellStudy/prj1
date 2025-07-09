package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
	
	@Autowired
	private TestMapper testMapper;

	@GetMapping("/")
	public int root() {
		return testMapper.test();
	}
	
}
