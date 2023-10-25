package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.command.BoardVO;
import org.zerock.dao.BoardDAO;
import org.zerock.service.BoardService;
import org.zerock.service.BoardServiceimple;

@Controller
@RequestMapping("/service/") //3rd 어노테이션을 이용한 빈등록! --> conponent -scan
public class BoardController {

	//BoardService 객체연결
	//1st (new 사용)
	//BoardService boardService = new BoardServiceimple();
	
	//2nd (xml에 bean등록 처리)
	@Autowired
	private BoardService boardService;
	
	//3nd 어노테이션을 이용한 빈등록!
	//@service
	
	
	//게시판 등록 화면처리
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		return "service/boardRegister";
	}
	
	//게시글 등록 요청 처리
	@RequestMapping(value = "/boardForm" , method = RequestMethod.POST)
	public String boardForm(
			@RequestParam("name") String name,
			@RequestParam("title") String title,
			@RequestParam("content") String content) {
		
		//boardService
		boardService.register(name, title, content);
		
		return "service/boardResult";
	}
	
	//게시글 리스트 보기 요청 처리
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		List<BoardVO> DB = boardService.getList();
		
		//전달 받은 DB를 boardList이름으로 저장
		model.addAttribute("boardList", DB);
		
		return "service/boardList";
	}
	
	
	//게시글 삭제 요청 처리
	@RequestMapping("/boardDelete" )
	public String boardDelete(@RequestParam("num")String num) {	
		boardService.delete(num);
		
	   return "redirect:/service/boardList";
	   
}	
}