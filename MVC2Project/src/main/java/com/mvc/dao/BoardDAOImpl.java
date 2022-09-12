package com.mvc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mvc.domain.BoardDTO;
import com.mvc.domain.PageDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
		// 마이바티스 객체생성
		@Inject
		private SqlSession sqlSession;
			
		// BoardMapper파일에 정의된 전체 이름을 변수에 저장
		private static final String namespace = "com.mvc.mappers.boardMapper";

		@Override
		public List<BoardDTO> getBoardList(PageDTO pageDTO) {
			return sqlSession.selectList(namespace+".getBoardList", pageDTO);
		}

		@Override
		public int getBoardCount() {
			return sqlSession.selectOne(namespace+".getBoardCount");
		}

		@Override
		public void insertBoard(BoardDTO boardDTO) {
			sqlSession.insert(namespace+".insertBoard", boardDTO);
		}

		@Override
		public BoardDTO getBoard(int num) {
			return sqlSession.selectOne(namespace+".getBoard", num);
		}

		@Override
		public void updateBoard(BoardDTO boardDTO) {
			sqlSession.update(namespace+".updateBoard", boardDTO);
		}

		@Override
		public void deleteBoard(int num) {
			sqlSession.delete(namespace+".deleteBoard", num);
		}
		
		
		
}
