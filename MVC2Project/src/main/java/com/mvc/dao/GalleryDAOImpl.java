package com.mvc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mvc.domain.GalleryDTO;
import com.mvc.domain.PageDTO;

@Repository
public class GalleryDAOImpl implements GalleryDAO {
	
		// 마이바티스 객체생성
		@Inject
		private SqlSession sqlSession;
			
		// GalleryMapper파일에 정의된 전체 이름을 변수에 저장
		private static final String namespace = "com.mvc.mappers.galleryMapper";

		@Override
		public List<GalleryDTO> getGalleryList(PageDTO pageDTO) {
			return sqlSession.selectList(namespace+".getGalleryList", pageDTO);
		}

		@Override
		public int getGalleryCount() {
			return sqlSession.selectOne(namespace+".getGalleryCount");
		}

		@Override
		public void insertGallery(GalleryDTO galleryDTO) {
			sqlSession.insert(namespace+".insertGallery", galleryDTO);
		}

		@Override
		public GalleryDTO getGallery(int num) {
			return sqlSession.selectOne(namespace+".getGallery", num);
		}

		@Override
		public void updateGallery(GalleryDTO galleryDTO) {
			sqlSession.update(namespace+".updateGallery", galleryDTO);
		}

		@Override
		public void deleteGallery(int num) {
			sqlSession.delete(namespace+".deleteGallery", num);
		}
		
		
		
}
