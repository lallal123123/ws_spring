package com.example.jpaEx_QM.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpaEx_QM.entity.Book;

@SpringBootTest
public class BookRepositoryTests {

	@Autowired
	BookRepository bookRepository;

	/*
	 * @Test public void insert() { IntStream.rangeClosed(1,10).forEach(i ->{ Book
	 * book= Book.builder() .title("Java" +i) .author("aaa") .publisher("green")
	 * .price(5000) .build();
	 * 
	 * bookRepository.save(book); });
	 */

	/*
	 * @Test public void findByAuthor() { //저자 이름으로 조회하기 : findByAuthor(문자열)
	 * 
	 * List<Book> list = bookRepository.findByAuthor("aaa");
	 * 
	 * for(Book book : list) { System.out.println(book); }
	 */

	/*
	 * @Test public void findByPrice() { //가격으로 조회하기 (8000원 이하) List<Book> list =
	 * bookRepository.findByPriceLessThanEqual(8000);
	 * 
	 * for(Book book : list) { System.out.println(book); }
	 */

	/*
	 * @Test public void findByPrice2() { //가격으로 조회하기 (8000원 미만) List<Book> list =
	 * bookRepository.findByPriceLessThan(8000);
	 * 
	 * for(Book book : list) { System.out.println(book); } }
	 */

	/*
	 * @Test public void findByPrice3() { List<Book> list =
	 * bookRepository.findByPriceBetween(10000, 20000); for (Book book : list) {
	 * System.out.println(book); } }
	 */
	@Test
	public void findByTitle() {
		List<Book> list = bookRepository.findByTitleContains("java");//대소문자 구분 안하는 듯
		//List<Book> list = bookRepository.findByTitleLike("%java%");
		for (Book book : list) {
			System.out.println(book);
		}
	}

}
