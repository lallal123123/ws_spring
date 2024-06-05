package com.example.jpaEx.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpaEx.entity.Memo;
import com.example.jpaEx.repository.MemoRepository;

@Controller
public class MyController {

	@Autowired
	MemoRepository ms;

	@RequestMapping("/")
	public String root() {
		return "index";
	}

	@RequestMapping("list")
	public void list(Model model) {
		Long memoCnt = ms.count();
		System.out.println("memoCnt" + memoCnt);
		List<Memo> list = ms.findByMnoBetweenOrderByMnoDesc(memoCnt - 9, memoCnt);
		model.addAttribute("list", list);
		Long pageCnt = (memoCnt - 1) / 10 + 1;
		Long pageBlock = 1L;

		System.out.println("페이지개수 : " + pageCnt);
		model.addAttribute("pageCnt", pageCnt);
		int page = 1;
		model.addAttribute("page", page);
		model.addAttribute("begin", (pageBlock * 5 - 4));
		model.addAttribute("end", (pageBlock * 5));
		model.addAttribute("pageBlock", pageBlock);
		Long pageBlockMax = (memoCnt - 1) / 50 + 1;

		model.addAttribute("pageBlockMax", pageBlockMax);

		model.addAttribute("endMax", pageCnt);

	}

	@RequestMapping("list1")
	public String list(@RequestParam("page") String page_, Model model) {
		//페이지당 메모수
		Long memoPerPage = 10L;
		//블록당 페이지 수
		Long pagePerBlock = 5L;
		// 현재페이지
		Long page = Long.parseLong(page_);
		model.addAttribute("page", page);
		// 전체 메모 수
		Long memoCnt = ms.count();		
		// 전체 페이지 수
		Long pageCnt = (memoCnt - 1) / memoPerPage + 1;
		// 현재 페이지 블록
		Long pageBlock = (page - 1) / pagePerBlock + 1;
		// 전체 페이지 블록 수
		Long pageBlockMax = (memoCnt - 1) / 50 + 1;
		
		//필요한 메모 리스트
		List<Memo> list = ms.findByMnoBetweenOrderByMnoDesc((memoCnt - ((page - 1) * memoPerPage)) - (memoPerPage-1),
				memoCnt - ((page - 1) * memoPerPage));

		model.addAttribute("list", list);

		model.addAttribute("pageCnt", pageCnt);
		Long end =(pageBlock * pagePerBlock);
		Long begin =(end - (pagePerBlock-1));
		model.addAttribute("begin",begin );
		
		model.addAttribute("end", end);
		model.addAttribute("pageBlock", pageBlock);

		model.addAttribute("pageBlockMax", pageBlockMax);

		model.addAttribute("endMax", pageCnt);

		return "list";
	}

	@RequestMapping("pageNext")
	public String pageNext(@RequestParam("pageBlock") String pageBlock_, Model model) {
		Long memoCnt = ms.count();
		Long memoPerPage = 10L;
		Long pagePerBlock = 5L;
		Long pageBlock = Long.parseLong(pageBlock_) + 1;
		Long page = (pageBlock * pagePerBlock) - (pagePerBlock-1);
		List<Memo> list = ms.findByMnoBetweenOrderByMnoDesc((memoCnt - ((page - 1) * memoPerPage)) - (memoPerPage-1),
				memoCnt - ((page - 1) * memoPerPage));
		model.addAttribute("list", list);
		Long pageCnt = (memoCnt - 1) / 10 + 1;
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("page", page);

		System.out.println(pageBlock);

		Long end =(pageBlock * pagePerBlock);
		Long begin =(end - (pagePerBlock-1));
		model.addAttribute("begin",begin );
		
		model.addAttribute("end", end);
		model.addAttribute("pageBlock", pageBlock);
		Long pageBlockMax = (memoCnt - 1) / 50 + 1;
		model.addAttribute("pageBlockMax", pageBlockMax);

		
		model.addAttribute("endMax", pageCnt);

		return "list";
	}

	@RequestMapping("pagePre")
	public String pagePre(@RequestParam("pageBlock") String pageBlock_, Model model) {
		Long memoCnt = ms.count();
		Long memoPerPage = 10L;
		Long pagePerBlock = 5L;
		Long pageBlock = Long.parseLong(pageBlock_) - 1;
		Long page = (pageBlock * pagePerBlock) - (pagePerBlock-1);
		List<Memo> list = ms.findByMnoBetweenOrderByMnoDesc((memoCnt - ((page - 1) * memoPerPage)) - (memoPerPage-1),
				memoCnt - ((page - 1) * memoPerPage));
		model.addAttribute("list", list);
		Long pageCnt = (memoCnt - 1) / 10 + 1;
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("page", page);

		System.out.println(pageBlock);

		Long end =(pageBlock * pagePerBlock);
		Long begin =(end - (pagePerBlock-1));
		model.addAttribute("begin",begin );
		
		model.addAttribute("end", end);
		model.addAttribute("pageBlock", pageBlock);

		Long pageBlockMax = (memoCnt - 1) / 50 + 1;
		model.addAttribute("pageBlockMax", pageBlockMax);


		model.addAttribute("endMax", pageCnt);

		return "list";
	}

}
