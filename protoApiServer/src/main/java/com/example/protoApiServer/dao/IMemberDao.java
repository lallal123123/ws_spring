package com.example.protoApiServer.dao;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.protoApiServer.dto.Member;

@Mapper
public interface IMemberDao {
	
	public void insert(@Param("member") Member member);
	public Member getMember(@Param("username") String username);
	

}
