package com.example.article.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.article.dto.Member;

@Mapper
public interface IMemberDao {

	public Member findByUsername(@Param("username") String username);
	public void reg(@Param("member") Member member);
}
