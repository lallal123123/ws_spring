package com.example.jpaEx_QM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaEx_QM.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	//쿼리메서드 ,저자이름으로 찾기
	List<Book> findByAuthor(String author);
	
	//가격으로 찾기
	List<Book> findByPriceLessThanEqual(int price);
	List<Book> findByPriceLessThan(int price);
	List<Book> findByPriceBetween(int from,int to);
	
	List<Book> findByTitleContains(String s);
}
