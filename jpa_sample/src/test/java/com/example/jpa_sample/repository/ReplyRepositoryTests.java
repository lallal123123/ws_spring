package com.example.jpa_sample.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa_sample.entity.Board;
import com.example.jpa_sample.entity.Reply;

@SpringBootTest
public class ReplyRepositoryTests {

	@Autowired
	ReplyRepository rr;
	
	//@Test
	public void insert() {
		IntStream.rangeClosed(1,300).forEach(i->{
			long bno = (long)(Math.random() *100) + 1;
			
			Board board =Board.builder().bno(bno).build();
			
			Reply reply = Reply.builder()
					.text("Reply..."+ i)
					.board(board)
					.replyer("guest")
					.build();
			rr.save(reply);
			
		});
		
	}
	
	@Test
	public void readReply1() {
		Optional<Reply> result= rr.findById(100L);
		Reply reply =result.get();
		System.out.println(reply);
		System.out.println(reply.getBoard());
	}
}
