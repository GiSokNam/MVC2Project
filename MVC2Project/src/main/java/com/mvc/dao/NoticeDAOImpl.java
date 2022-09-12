package com.mvc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mvc.domain.NoticeDTO;
import com.mvc.domain.PageDTO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
		// 마이바티스 객체생성
		@Inject
		private SqlSession sqlSession;
			
		// noticeMapper파일에 정의된 전체 이름을 변수에 저장
		private static final String namespace = "com.mvc.mappers.noticeMapper";

		@Override
		public List<NoticeDTO> getNoticeList(PageDTO pageDTO) {
			return sqlSession.selectList(namespace+".getNoticeList", pageDTO);
		}

		@Override
		public int getNoticeCount() {
			return sqlSession.selectOne(namespace+".getNoticeCount");
		}

		@Override
		public void insertNotice(NoticeDTO noticeDTO) {
			sqlSession.insert(namespace+".insertNotice", noticeDTO);
		}

		@Override
		public NoticeDTO getNotice(int num) {
			return sqlSession.selectOne(namespace+".getNotice", num);
		}

		@Override
		public void updateNotice(NoticeDTO noticeDTO) {
			sqlSession.update(namespace+".updateNotice", noticeDTO);
		}

		@Override
		public void deleteNotice(int num) {
			sqlSession.delete(namespace+".deleteNotice", num);
		}
		
		
		
}
