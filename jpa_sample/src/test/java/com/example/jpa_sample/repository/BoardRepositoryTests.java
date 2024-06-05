package com.example.jpa_sample.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_sample.entity.Board;
import com.example.jpa_sample.entity.Member;

@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	BoardRepository br;
	
	//@Test
	public void insertBoard() {
		IntStream.rangeClosed(1, 100).forEach(i->{
			Member member = Member.builder()
					.email("user" + i + "@naver.com").build();
			
			
			Board board = Board.builder()
					.title("title..." + i)
					.content("content..."+ i)
					.writer(member)
					.build();
			br.save(board);
		});
	}
	
	@Test
	public void testRead1() {
		Optional<Board> result = br.findById(100L);
		
		Board board = result.get();
		
		System.out.println(board);
		System.out.println(board.getWriter());
	}
}
