package com.example.jdbcPrj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jdbcPrj.domain.MemberDto;

@Repository			//스프링컨테이너에 빈(클래스)으로 등록하는 어노테이션이 있다, 객체의 생명주기(생성,소멸)를 맡긴다
public class MemberDao {  	//클래스 위에 @Repository를 쓰면 이클래스를 빈으로 등록하겠다는 것

	@Autowired		//자동으로 결합하겠다.  객체생성(new ...)을 직접 안하고 맡김(딱맞는)-자료형이 인터페이스일때 구현하는 클래스가 여러개있을경우는 지정해줘야함
	private JdbcTemplate jdbcTemplate;
	public List<MemberDto> getList(){
		String query = "select * from member";
		List<MemberDto> list = jdbcTemplate.query(
				query,new BeanPropertyRowMapper<MemberDto>(MemberDto.class)
				);
		
		return list;
				
	}
}
