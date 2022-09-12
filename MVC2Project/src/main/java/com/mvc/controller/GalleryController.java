package com.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.domain.GalleryDTO;
import com.mvc.domain.PageDTO;
import com.mvc.service.GalleryService;

@Controller
public class GalleryController {
	
	@Inject
	private GalleryService galleryService;
	
	
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String Gallery(HttpServletRequest request, Model model) {
		
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
		
		List<GalleryDTO> galleryList = galleryService.getGalleryList(pageDTO);
		
				
		//전체 글개수 구하기
		int count = galleryService.getGalleryCount();
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
			
		model.addAttribute("galleryList", galleryList);
		model.addAttribute("pageDTO", pageDTO);
	
		return "gallery/gallery";
	}
	

	@RequestMapping(value = "/gallery/write", method = RequestMethod.GET)
	public String write(HttpServletRequest request, Model model) {
		
		
		return "gallery/write";
	}
	

	@RequestMapping(value = "/gallery/writePro", method = RequestMethod.POST)
	public String writePro(GalleryDTO galleryDTO) {

		galleryService.insertGallery(galleryDTO);
		
		return "redirect:/gallery";
	}
	

	@RequestMapping(value = "/gallery/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		GalleryDTO galleryDTO = galleryService.getGallery(num);
		
		model.addAttribute("galleryDTO", galleryDTO);
		
		
		return "gallery/content";
	}

	@RequestMapping(value = "/gallery/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		GalleryDTO galleryDTO = galleryService.getGallery(num);
		
		model.addAttribute("galleryDTO", galleryDTO);
		
		
		return "gallery/update";
	}
	

	@RequestMapping(value = "/gallery/updatePro", method = RequestMethod.POST)
	public String updatePro(GalleryDTO galleryDTO) {
		
		galleryService.updateGallery(galleryDTO);
		
		return "redirect:/gallery";
	}
	
	@RequestMapping(value = "/gallery/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		galleryService.deleteGallery(num);
		
		return "redirect:/gallery";
	}
	
}
