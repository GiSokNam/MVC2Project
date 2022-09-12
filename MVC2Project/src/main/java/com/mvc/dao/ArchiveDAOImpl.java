package com.mvc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mvc.domain.ArchiveDTO;
import com.mvc.domain.PageDTO;

@Repository
public class ArchiveDAOImpl implements ArchiveDAO {
	
		// 마이바티스 객체생성
		@Inject
		private SqlSession sqlSession;
			
		// ArchiveMapper파일에 정의된 전체 이름을 변수에 저장
		private static final String namespace = "com.mvc.mappers.archiveMapper";

		@Override
		public List<ArchiveDTO> getArchiveList(PageDTO pageDTO) {
			return sqlSession.selectList(namespace+".getArchiveList", pageDTO);
		}

		@Override
		public int getArchiveCount() {
			return sqlSession.selectOne(namespace+".getArchiveCount");
		}

		@Override
		public void insertArchive(ArchiveDTO archiveDTO) {
			sqlSession.insert(namespace+".insertArchive", archiveDTO);
		}

		@Override
		public ArchiveDTO getArchive(int num) {
			return sqlSession.selectOne(namespace+".getArchive", num);
		}

		@Override
		public void updateArchive(ArchiveDTO archiveDTO) {
			sqlSession.update(namespace+".updateArchive", archiveDTO);
		}

		@Override
		public void deleteArchive(int num) {
			sqlSession.delete(namespace+".deleteArchive", num);
		}
		
		
		
}
