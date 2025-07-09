package com.java;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

	@Select("select 5 as cnt")
	public int test();
	
}
