package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.mapper.TestMapper;

@RestController
public class DataController {
	
	@Autowired
	private TestMapper testMapper;

	@GetMapping("/db_test")
	public int root() {
		return testMapper.test();
	}
	
}
