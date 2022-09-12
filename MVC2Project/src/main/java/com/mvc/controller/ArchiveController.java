package com.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.domain.ArchiveDTO;
import com.mvc.domain.PageDTO;
import com.mvc.service.ArchiveService;

@Controller
public class ArchiveController {
	
	@Inject
	private ArchiveService archiveService;
	
	
	@RequestMapping(value = "/archive", method = RequestMethod.GET)
	public String archive(HttpServletRequest request, Model model) {
		
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
		
		List<ArchiveDTO> archiveList = archiveService.getArchiveList(pageDTO);
		
				
		//전체 글개수 구하기
		int count = archiveService.getArchiveCount();
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
			
		model.addAttribute("archiveList", archiveList);
		model.addAttribute("pageDTO", pageDTO);
		
		return "archive/archive";
	}
	

	@RequestMapping(value = "/archive/write", method = RequestMethod.GET)
	public String write(HttpServletRequest request, Model model) {
		
		
		return "archive/write";
	}
	

	@RequestMapping(value = "/archive/writePro", method = RequestMethod.POST)
	public String writePro(ArchiveDTO archiveDTO) {

		archiveService.insertArchive(archiveDTO);
		
		return "redirect:/archive";
	}
	

	@RequestMapping(value = "/archive/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		ArchiveDTO archiveDTO = archiveService.getArchive(num);
		
		model.addAttribute("archiveDTO", archiveDTO);
		
		
		return "archive/content";
	}

	@RequestMapping(value = "/archive/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		ArchiveDTO archiveDTO = archiveService.getArchive(num);
		
		model.addAttribute("archiveDTO", archiveDTO);
		
		
		return "archive/update";
	}
	

	@RequestMapping(value = "/archive/updatePro", method = RequestMethod.POST)
	public String updatePro(ArchiveDTO archiveDTO) {
		
		archiveService.updateArchive(archiveDTO);
		
		return "redirect:/archive";
	}
	
	@RequestMapping(value = "/archive/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		archiveService.deleteArchive(num);
		
		return "redirect:/archive";
	}
	
}
