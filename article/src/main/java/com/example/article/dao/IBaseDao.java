package com.example.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface IBaseDao<T> {

	public List<T> list(String id);
	public void insert(@Param("dto") T dto);
	public void delete(String id);
	public void update(T dto);
	public T detail(@Param("id") String id);
	
}
