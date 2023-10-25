package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.command.JoinVO;
import org.zerock.service.JoinService;
import org.zerock.service.Joinserviceimpl;

@Controller
@RequestMapping("/service/*")
public class ServiceController {
	
	@Autowired
	JoinService joinService;
	
	
	// /serviece/이후에 매핑정보가 없는 경우 보여질 부분
	@RequestMapping("")
	public String basic() {
		return "home";
	}
	
	//화면 처리 부분.....view
	@RequestMapping(value = "/member_ex01" , method = RequestMethod.GET)
//	@GetMapping("/member_ex01") 같은 get방식으로 처리
	public String member_ex01() {
		return "service/member_ex01";
	}
	
	@PostMapping("/join")
	public String join(JoinVO vo) {
		
		//JoinVO로 전달 받은 값을 처리...
		joinService.insertMember(vo); 
		return "service/member_ex02";
		
	}
	
	//로그인 화면으로 이동
	@RequestMapping("/member_ex03")
	public String member_ex03() {
		return "service/member_ex03";
	}
	
	//로그인 처리
	@RequestMapping("login")
	public String login(JoinVO vo, Model model, RedirectAttributes RA) {
		
		//로그인 유효성 검사(서비스 아이디 검사)
		int result = joinService.memberCheck(vo);
		
		if(result ==1) { //로그인 성공 => member_mypage
			model.addAttribute("memberInfo", vo);
			return "service/member_mypage"; //마이페이지로 이동
		}else {//로그인 실패 
			RA.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "redirect:/service/member_ex03";
		}
		
	}
	
}
