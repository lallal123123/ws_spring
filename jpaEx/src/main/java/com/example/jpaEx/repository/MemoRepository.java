package com.example.jpaEx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long>{	//JpaRepository<entity클래스,기본키의 자료형>
	//save(엔티티),findById(아이디),deleteById(아이디),findAll(),count()
	List<Memo> findByMnoBetweenOrderByMnoDesc(Long from,Long to);	//메서드 이름에 쿼리문이 담기기 때문에 복잡하게 만들어질수도 있음
}
