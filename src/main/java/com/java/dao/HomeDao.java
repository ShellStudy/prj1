package com.java.dao;

import java.util.List;

import com.java.dto.Ex1DTO;

public interface HomeDao {

	public List<Ex1DTO> findList(String accept);
	public Ex1DTO findOne(int no);
	public int edit(Ex1DTO ex1DTO);
	public int accept(Ex1DTO ex1DTO);
	public Ex1DTO save(Ex1DTO ex1DTO);
	
}
