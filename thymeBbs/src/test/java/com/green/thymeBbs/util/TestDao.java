package com.green.thymeBbs.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.thymeBbs.dao.IEvalBbsDao;
import com.green.thymeBbs.dto.EvalBbsDto;

@SpringBootTest
class TestDao {

	@Autowired
	IEvalBbsDao dao;
	
	
	
	@Test
	void listSizeTest() {
		List<EvalBbsDto> list = dao.list();
		assertThat(list.size()).isEqualTo(4);
	}

	/*
	@Test
	void bnoNotEmptyTest() {
		String bno_ = "2";
		int bno = Integer.parseInt(bno_);
		// 해당 글의 내용이 나오는지 검증
		assertThat(dao.detail(bno_).getContent()).isNotEmpty();
		assertThat(dao.detail(bno_).getContent()).isNotNull();
		

	}
	*/
	
	@Test
	void bnoIsPositiveTest() {
		// bno가 음수가 있는지 검증
		List<EvalBbsDto> list = dao.list();
		for (EvalBbsDto dto : list) {
			assertThat(dto.getBno()).isPositive();
		}
	}


	@Test
	void writerIsMemberTest() {
		List<EvalBbsDto> list = dao.list();
		
		for (EvalBbsDto dto : list) {
			assertThat(dto.getWriter()).isIn(
					"홍길동",
					"김개똥",
					"임꺽정",
					"일지매"
			);
		}
	}
	@Test
	void contentContainTest() {
		// 게시글 내용에 특정 단어사용이 없는지 검증
		List<EvalBbsDto> list = dao.list();
		String[] strs = { "금지어1", "금지어2", "금지어3" };
		for (EvalBbsDto dto : list) {
			for (String s : strs) {

				assertThat(dto.getContent()).doesNotContain(s);
			}
		}
	}

	@Test
	void titleStartsTest() {
		// 게시글 제목인 빈공간으로 시작하는 경우가 있는지 검증
		List<EvalBbsDto> list = dao.list();
		for (EvalBbsDto dto : list) {
			assertThat(dto.getTitle()).doesNotStartWith(" ");
		}
	}
	
	@Test
	void detailTest() {
		// 해당 게시글의 내용이 실제 데이터와 같은지 검증
		String bno_ = "2";
		int bno = Integer.parseInt(bno_);
		EvalBbsDto dto = dao.detail(bno_);
		assertThat(dto.getBno()).isEqualTo(bno);
		assertThat(dto.getTitle()).isEqualTo("2번제목");
		assertThat(dto.getContent()).isEqualTo("2번번내용");
		assertThat(dto.getWriter()).isEqualTo("홍길동");
		assertThat(dto.getRegdate()).isEqualTo("2024-04-21");		
		
	}
	/*
	@Test
	void deleteTest() {
		List<EvalBbsDto> list = dao.list();
		assertThat(list.size()).isEqualTo(4);
		dao.delete("4");
		list = dao.list();
		assertThat(list.size()).isEqualTo(3);
	}
	*/
	
	@Test
	void writeTest() {
		List<EvalBbsDto> list = dao.list();
		assertThat(list.size()).isEqualTo(3);
		EvalBbsDto inputDto = new EvalBbsDto();
		inputDto.setTitle("5번제목");
		inputDto.setWriter("임꺽정");
		inputDto.setContent("5번내용");
		dao.write(inputDto);
		list = dao.list();
		assertThat(list.size()).isEqualTo(4);
		
	}
	
	
}
