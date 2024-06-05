package com.example.restApiEx.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiEx.dto.MemoDto;
import com.example.restApiEx.entity.Memo;
import com.example.restApiEx.repository.MemoRepository;

@RestController
@RequestMapping("/memoapp")
public class Memocontroller {

	@Autowired
	private MemoRepository mr;
	
	
	@RequestMapping("/main")
	public String root() {
		return "hello memo";
	}

	// GET 메소드(서버에 자료 요청할 때 - 어떤 저료인지 식별할 수 있는 파라미터가 있겠다.)
	//http://localhost:8095/memoapp/memo?mno=1
	@GetMapping("/memo")
	public Memo getMemo(@RequestParam("mno") Integer mno) {
		System.out.println("getMemo.......mno : " + mno);
		
		Optional<Memo> result = mr.findById(mno);
		Memo memo =result.get();
		return memo;
	}

	// POST 메서드(서버에 자료 새로 등록할 때 - ajax로 json 데이터가 파라미터로 넘어온다.)
	//http://localhost:8095/memoapp/memo
	//{ "title" : "test title..", "content" : "test content...", "writer" : "hgd"}
	@PostMapping("/memo")
	public Memo postMemo(@RequestBody MemoDto memoDto) {	//폼형식이 아닌 제이슨형식으로 넘어온 객체를 받을때 @RequestBody씀
		System.out.println("postMemo......memoDto : " + memoDto);
		Memo memo = new Memo();
		memo.setMno(memoDto.getMno());
		memo.setTitle(memoDto.getTitle());
		memo.setContent(memoDto.getContent());
		memo.setWriter(memoDto.getWriter());
		
		Memo result = mr.save(memo);
		
		return result;
	}

	// PUT 메서드(서버에 자료 재 등록할 때)
	//http://localhost:8095/memoapp/memo
		//{ "title" : "test title..", "content" : "test content...", "writer" : "hgd"}
	@PutMapping("/memo")
	public String putMemo(@RequestBody MemoDto memoDto) {
		System.out.println("putMemo......memoDto : " + memoDto);
		Memo memo = new Memo();
		memo.setMno(memoDto.getMno());
		memo.setTitle(memoDto.getTitle());
		memo.setContent(memoDto.getContent());
		memo.setWriter(memoDto.getWriter());
		
		Memo result = mr.save(memo);
		return result.toString();
	}

	// DELETE 메서드(서버의 자료 삭제할 때 - 삭제할 자료를 식별할 수 있는 파라미터가 넘어온다.)
	//http://localhost:8095/memoapp/memo/1
	@DeleteMapping("/memo/{mno}")
	public String deleteMemo(@PathVariable("mno") Integer mno) {
		System.out.println("deleteMemo.......mno : " + mno);
		
		mr.deleteById(mno);
		if(mr.existsById(mno)) {
			return "실패";
		}
		return "성공";
	}

}
