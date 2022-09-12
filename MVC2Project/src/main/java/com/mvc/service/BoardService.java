package com.mvc.service;

import java.util.List;

import com.mvc.domain.BoardDTO;
import com.mvc.domain.PageDTO;

public interface BoardService {

	List<BoardDTO> getBoardList(PageDTO pageDTO);
	
	int getBoardCount();

	void insertBoard(BoardDTO boardDTO);

	BoardDTO getBoard(int num);

	void updateBoard(BoardDTO boardDTO);

	void deleteBoard(int num);

	


}
