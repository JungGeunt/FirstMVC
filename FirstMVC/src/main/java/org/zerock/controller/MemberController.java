package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.member.model.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

//	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST) 
	//주소값이 "/memberJoin"일때 POST방식으로 데이타를 받습니다.
	@GetMapping("/memberJoin")  // GET , Post ,Put, Delete 메서드 맵핑 어노테이션이 존재함.
	public String memJoin() {
		System.out.println("memberJoin 에 접근...");
		return "member/memJoin";  //WEB-INF/views/+ member/memJoin +/jsp
	}
	
	@RequestMapping(value = "/memLogin" , method = RequestMethod.GET ) 
	public String memLogin(Model model) {
		
		return "member/memLogin";
	}
	
	//값을 받아서 처리하는 로그인
	@RequestMapping(value = "/memLogin", method = RequestMethod.POST)  
	public String memLogin(Model model,
//			request 객체를 사용하는 방법			
//			HttpServletRequest request
//			어노테이션을 이용하는 방법
			//@RequestParam의 추가 속성 
			//@RequestParam(value = "파라미터 값", required =false, defaultValue ="기본값")
			//하나의 인자를 사용한 경우 파라미터 값
			//1. required : 해당 파라미터가 필수가 아닌 경우 지정, 기본: true  false = 뜻하는 것 필수 아님
			//2. defaultValue : requird 지정시 기본 값 지정
//			@RequestParam("memId") String memId,
//			@RequestParam("memPw") String memPw,
//			@RequestParam(value = "memName", required = false, defaultValue = "tester" )
//						String name
			//3. 커맨드 정보를 이용한 HTTP 정보 얻기
			//vo 객체에 동일한 setter가 있으면 자동으로 저장(스프링은 vo에 대해 자동으로 처리)
			MemberVO mem
			) {
		//1.전통적인 방법
//		String memId= request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
		
//		System.out.println(memId);
//		System.out.println(memPw);
//		System.out.println(name);
		
		System.out.println(mem.getMemId());
		System.out.println(mem.getMemPw());
		System.out.println(mem.getName());
		
		/* 4.Model
		 * 컨트롤러에서 뷰에 데이터를 전달하기 위해서 사용되는 객체로 Model과 ModelAndView가 있다.
		 * 1. Model은 데이터만 전달.
		 * 2. ModelAndView 데이터와 뷰의 이름을 함께 전달.
		 */
		
		//Model : addAttribute("전달이름" , 값);
		model.addAttribute("memId", mem.getMemId());
		model.addAttribute("memPw", mem.getMemPw());
		
		model.addAttribute("mem" , mem);
		
		return "member/memLogin_ok";
	}
	
	//ModelAndView 방식
	@RequestMapping(value = "/memLoginModelAndView", method = RequestMethod.POST)
	public ModelAndView memPut(Model model, MemberVO memVO) {
		//객체 생성
		ModelAndView mav = new ModelAndView();
		
		//ModelAndView에 값을추가
		mav.addObject("memId" , memVO.getMemId());
		mav.addObject("mem" , memVO);
		
		//View 설정
		mav.setViewName("member/memLogin_ok");
		
		return mav;
	}
	
	@RequestMapping("/req_ex01")
	public void req_ex01() { //void는 접속 경로의 파일 이름을 사용
		//접속 경로는(uri 중 context 경로 뺀)는? => member/req_ex01
		System.out.println("req_ex01로 접근했습니다.");
	}
	
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "member/req_ex02";
	}
	
	@RequestMapping("/req_ex03") //샌드리다이렉트 비슷한 개념 URL로 접근 ->나갔다 다시 접근
	public String req_ex03() {
		return "redirect:/member/req_ex01";
	}
	
	@ResponseBody 		//메서드에 리턴 값을 view리졸버로 전달x, 해당 메서드를 호출한 곳으로 결과를 반환 데이터를 전달
	@RequestMapping("/test")
	public String testResponseBody() {
		return "<h2>testResponseBody</h2>";
	}
	
}
