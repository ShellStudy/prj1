package com.java.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.java.dto.Ex1DTO;
import com.java.mapper.HomeMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class HomeDaoImp implements HomeDao {
	
	private final HomeMapper homeMapper;

	@Override
	public List<Ex1DTO> findList(String accept) {
		return homeMapper.findList(accept);
	}

	@Override
	public Ex1DTO findOne(int no) {
		return homeMapper.findOne(no);
	}

	@Override
	public int edit(Ex1DTO ex1DTO) {
		return homeMapper.edit(ex1DTO);
	}

	@Override
	public int accept(Ex1DTO ex1DTO) {
		return homeMapper.accept(ex1DTO);
	}

	@Override
	public Ex1DTO save(Ex1DTO ex1DTO) {
		int status = homeMapper.save(ex1DTO);
		return (status == 1) ? ex1DTO : null;
	}

}
