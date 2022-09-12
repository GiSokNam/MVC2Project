package com.mvc.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.dao.MemberDAO;
import com.mvc.domain.MemberDTO;
import com.mvc.service.MemberService;


@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private MemberDAO memberDAO;
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String Main() {
		
		
		return "member/main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		
		return "member/login";
	}
	
	@RequestMapping(value = "/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO memberDTO, HttpSession session) {
		
		// login form에 입력된 id가 DB에 존재하는지 확인
		// 메서드 호출
		MemberDTO memberDTO2 = memberService.userCheck(memberDTO);
		if(memberDTO2 != null) {
			// 아이디 비밀번호 일치
			// 세션값 생성
			session.setAttribute("id", memberDTO.getId());
			// 가상주소 /main 이동
			return "redirect:/main";
		}else {
			// 아이디 비밀번호 틀림
			// WEB-INF/views/member/msg.jsp 이동
			return "member/msg";
		}
		
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		// session값 초기화 후 메인화면으로 이동
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		
		
		return "member/join";
	}
	
	
	// 스프링에서 MemberDTO memberDTO값을 가져올 수 있는 이유는
	// Form 태그이름과 MemberDTO 멤버변수이름이 일치하면 자동으로
	// Form의 내용이 MemberDTO에 저장되며
	// 한글처리는 web.xml에서 한다(인코딩 코드 입력)
	@RequestMapping(value = "/joinPro", method = RequestMethod.POST)
	public String joinPro(MemberDTO memberDTO) {
		
		// memberService에 interface 추상메서드 생성 후
		// memberServiceImpl에서 interface를 구현한다.
		// 이것은 수정해야할 경우 수정을 최소화하기 위한 방법이다.
		// 메서드 호출
		memberService.insertMember(memberDTO);
		
		// 주소 변경하면서 이동(redirect 코드가 필요) => 로그인 화면(member/login)
		// redirect: 로그인 가상주소 => 로그인 화면
		return "redirect:/login";
	}
	
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPage(HttpSession session) {
		
		
		return "member/mypage";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		
		String id=(String)session.getAttribute("id");
		
		MemberDTO memberDTO=memberService.getMember(id);
		
		model.addAttribute("memberDTO", memberDTO);
		
		return "member/update";
	}
	
	@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO memberDTO) {
		
		// 메서드호출
		MemberDTO memberDTO2=memberService.userCheck(memberDTO);
		if(memberDTO2!=null) {
			//아이디 비밀번호 일치
			//수정
			memberService.updateMember(memberDTO);
			// 가상주소 /main/main 이동
			return "redirect:/main";
		}else {
			//아이디 비밀번호 틀림
			// WEB-INF/views/member/msg.jsp 이동
			return "member/msg";
		}
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		model.addAttribute("id", id);
		
		return "member/delete";
	}
	
	@RequestMapping(value = "/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO memberDTO, HttpSession session) {
		
		memberService.deleteMember(memberDTO);
		
		session.invalidate();
		
		return "redirect:/main";
	}
	
	 
}
