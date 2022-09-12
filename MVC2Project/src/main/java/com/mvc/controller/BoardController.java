package com.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.domain.BoardDTO;
import com.mvc.domain.PageDTO;
import com.mvc.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String Board(HttpServletRequest request, Model model) {
		
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
		
		List<BoardDTO> boardList = boardService.getBoardList(pageDTO);
		
				
		//전체 글개수 구하기
		int count = boardService.getBoardCount();
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
			
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO", pageDTO);
	
		return "board/board";
	}
	

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(HttpServletRequest request, Model model) {
		
		
		return "board/write";
	}
	

	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String writePro(BoardDTO BoardDTO) {

		boardService.insertBoard(BoardDTO);
		
		return "redirect:/board";
	}
	

	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, Model model) {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		BoardDTO boardDTO = boardService.getBoard(num);
		
		model.addAttribute("boardDTO", boardDTO);
		
		
		return "board/content";
	}

	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDTO boardDTO = boardService.getBoard(num);
		
		model.addAttribute("boardDTO", boardDTO);
		
		
		return "board/update";
	}
	

	@RequestMapping(value = "/Board/updatePro", method = RequestMethod.POST)
	public String updatePro(BoardDTO boardDTO) {
		
		boardService.updateBoard(boardDTO);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		boardService.deleteBoard(num);
		
		return "redirect:/board";
	}
	
}
