package com.mvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mvc.dao.BoardDAO;
import com.mvc.domain.BoardDTO;
import com.mvc.domain.PageDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> getBoardList(PageDTO pageDTO) {
		
		return boardDAO.getBoardList(pageDTO);
	}

	@Override
	public int getBoardCount() {
		
		return boardDAO.getBoardCount();
	}

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		
		boardDAO.insertBoard(boardDTO);
	}

	@Override
	public BoardDTO getBoard(int num) {
		
		return boardDAO.getBoard(num);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		
		boardDAO.updateBoard(boardDTO);
	}

	@Override
	public void deleteBoard(int num) {
		
		boardDAO.deleteBoard(num);
	}
	
	
	
}
