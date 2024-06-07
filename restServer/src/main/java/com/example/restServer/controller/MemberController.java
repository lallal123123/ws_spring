package com.example.restServer.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restServer.Repository.BoardRepository;
import com.example.restServer.dto.BoardDto;
import com.example.restServer.entity.Board;
import com.example.restServer.entity.Member;

import net.coobird.thumbnailator.Thumbnails;

@CrossOrigin("*")
@RestController
@RequestMapping("/member")
public class MemberController {
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	//@Autowired
	private BoardRepository br;
	
	public MemberController(BoardRepository br) {
		this.br = br;
	}
	
	//로그인이 끝난 상태 ->멤버메인페이지 -> 서비스를 이용하는 단계(게시물을 보거나 등록)
	//메인 페이지
	//@GetMapping("/main")
	public String main() {
		return "member/main";
	}
	//게시물 등록(등록 폼,등록처리)
	//@GetMapping("/regBoard")
	public String regBoard() {
		return "member/regBoardForm";
	}
	
	@PostMapping("/regBoardProc")
	public @ResponseBody String regBoardProc(BoardDto boardDto) {
		Board board =new Board();
		board.setTitle(boardDto.getTitle());
		board.setContent(boardDto.getContent());
		//작성자에 관한 세팅
		Member member = new Member();
		member.setUsername(boardDto.getWriter());
		board.setMember(member);
		//파일 관련 멤버변수 세팅
		String originName =boardDto.getFileName();
		board.setOriginName(originName);
		String newName = UUID.randomUUID().toString() + originName;//중복되지 않는 새이름
		board.setNewName(newName);
		String thumbNailName = "";
		
		//파일처리
		File file = new File(newName);
		
		try {
			boardDto.getFile().transferTo(file);
			System.out.println("파일 업로드 성공....");
			
			//썸네일 생성
			String thumbnailSaveName = "s_" + newName;
			board.setThumbnailName(thumbnailSaveName);
			
			File thumbfile = new File(uploadPath + thumbnailSaveName);
			File ufile = new File(uploadPath + newName);
			
			Thumbnails.of(ufile).size(100,100).toFile(thumbfile);
		}catch(Exception e){
			
		}
		Board result =br.save(board);
		
		if(result !=null) {
			return "등록";
		}else {
			return "실패";
		}
		
		
	}
	
	
	
	//게시물 조회
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board>	list = br.findAll();
		model.addAttribute("boardList", list);
		return "/member/boardList";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("bno") int bno,Model model) {
		
		Optional<Board> result =br.findById(bno);
		Board board = result.get();
		model.addAttribute("board", board);
		return "/member/getBoard";
	}

}
