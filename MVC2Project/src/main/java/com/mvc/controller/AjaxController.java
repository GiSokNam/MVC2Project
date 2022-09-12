package com.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.domain.MemberDTO;
import com.mvc.domain.NoticeDTO;
import com.mvc.domain.PageDTO;
import com.mvc.service.MemberService;
import com.mvc.service.NoticeService;


@RestController
public class AjaxController {
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private NoticeService noticeService;
	
	// http://localhost:8080/FunWeb/member/dupCheck?id=kim
	@RequestMapping(value = "/member/dupCheck", method = RequestMethod.GET)
	public ResponseEntity<String> dupCheck(HttpServletRequest request) {
		String result = "";
		String id = request.getParameter("id");
		
			
		MemberDTO memberDTO = memberService.getMember(id);
		if(memberDTO!=null) {
				//아이디 있음 아이디 중복
			result="iddup";
		}else {
				//아이디 없음 아이디 사용가능
			result="idok";
		}
			
		ResponseEntity<String> entity = new ResponseEntity<String>(result,HttpStatus.OK);
		return  entity;
	}
	
	@RequestMapping(value = "/notice/listjson", method = RequestMethod.GET)
	public ResponseEntity<List<NoticeDTO>> listjson() {
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(5);
		pageDTO.setPageNum("1");
		pageDTO.setCurrentPage(1);
		
		List<NoticeDTO> noticeList = noticeService.getNoticeList(pageDTO);
		
		ResponseEntity<List<NoticeDTO>> entity = new ResponseEntity<List<NoticeDTO>>(noticeList,HttpStatus.OK);
		return  entity;
	}
	
}
