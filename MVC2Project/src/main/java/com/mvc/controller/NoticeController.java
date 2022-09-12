package com.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.domain.NoticeDTO;
import com.mvc.domain.PageDTO;
import com.mvc.service.NoticeService;

@Controller
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(HttpServletRequest request, Model model) {
		
		// 한화면에 보여줄 글의 개수
		int pageSize = 15;
		
		// pageNum 가져오기
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		
		// pageNum 정수형 변경
		int currentPage = Integer.parseInt(pageNum);
		
		// PageDTO 객체생성
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageSize(pageSize);
		pageDTO.setPageNum(pageNum);
		pageDTO.setCurrentPage(currentPage);
		
		List<NoticeDTO> noticeList = noticeService.getNoticeList(pageDTO);
		
				
		//전체 글개수 구하기
		int count = noticeService.getNoticeCount();
		//페이징 처리
		// pageBlock startPage endPage pageCount
		int pageBlock = 10;
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		int pageCount = count / pageSize +(count % pageSize == 0? 0 : 1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
						
		pageDTO.setCount(count);
		pageDTO.setPageBlock(pageBlock);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		pageDTO.setPageCount(pageCount);
			
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "notice/notice";
	}
	

	@RequestMapping(value = "/notice/write", method = RequestMethod.GET)
	public String write(HttpServletRequest request, Model model) {
		
		
		return "notice/write";
	}
	

	@RequestMapping(value = "/notice/writePro", method = RequestMethod.POST)
	public String writePro(NoticeDTO noticeDTO) {

		noticeService.insertNotice(noticeDTO);
		
		return "redirect:/notice";
	}
	

	@RequestMapping(value = "/notice/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		NoticeDTO noticeDTO = noticeService.getNotice(num);
		
		model.addAttribute("noticeDTO", noticeDTO);
		
		
		return "notice/content";
	}

	@RequestMapping(value = "/notice/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		NoticeDTO noticeDTO = noticeService.getNotice(num);
		
		model.addAttribute("noticeDTO", noticeDTO);
		
		
		return "notice/update";
	}
	

	@RequestMapping(value = "/notice/updatePro", method = RequestMethod.POST)
	public String updatePro(NoticeDTO noticeDTO) {
		
		noticeService.updateNotice(noticeDTO);
		
		return "redirect:/notice";
	}
	
	@RequestMapping(value = "/notice/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		noticeService.deleteNotice(num);
		
		return "redirect:/notice";
	}
	
}
