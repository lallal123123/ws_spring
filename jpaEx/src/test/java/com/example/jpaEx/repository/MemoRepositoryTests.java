package com.example.jpaEx.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpaEx.entity.Memo;

@SpringBootTest
public class MemoRepositoryTests {

	@Autowired
	MemoRepository memoRepository;
	
	//@Test
	public void testClass() {
		System.out.println(memoRepository.getClass().getName());
	}
	
	//@Test	//insert : C --save(엔티티)
	public void testINsertDummies() {
		
		for(int i = 0 ; i < 100 ; i++) {
			Memo memo = new Memo("Sample...." + i);
			memoRepository.save(memo);		// save()는 인터페이스가 상속받은 쪽(JpaRepository<Memo, Long>)에서 받은 메서드 
		}
				
		/* 위랑 같은 코드임
		IntStream.rangeClosed(1,100).forEach( i ->{
			Memo memo = Memo.builder().memoText("Sample...." + i).build();
			
			memoRepository.save(memo);
		})
		*/
	}
	
	//@Test
	public void testSelect() {
		Long mno = 100L;
		
		Optional<Memo> result =memoRepository.findById(mno);	//optional<엔티티>로 반환함 ( 반환값이 null일때 에러안나게 하기위해)
		
		System.out.println("================");
		
		if(result.isPresent()) {		//없는 데이터는 아예 안나옴(mno가 100까진데 101넣었을때)
			Memo memo = result.get();
			System.out.println(memo);
		}
		
	}
	
	//@Test
	public void testUpdate() {
		Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();		//기존에 있던 자료를 넣으면 업데이트가 됨
		
		System.out.println(memoRepository.save(memo));
	}
	
	//@Test
	public void testDelete() {
		Long mno = 100L;
		
		memoRepository.deleteById(mno);
	}
	
	//@Test
	public void testCount() {
		
		long cnt = memoRepository.count();
		
		System.out.println("cnt : " + cnt);
		
		assertEquals(cnt,100);
	}
	
	@Test
	public void tt() {
		
		List<Memo> list = memoRepository.findAll();
		
		for( Memo m : list) {
			System.out.println(m.getMno()); 
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
