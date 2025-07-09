package com.java.service;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface HomeService {

	public String list(Model model, HttpServletRequest req);
	public String detail(Model model, HttpServletRequest req);
	public String accept(HttpServletRequest req);
	public String edit(HttpServletRequest req);
	public String input(HttpServletRequest req);
	
}
