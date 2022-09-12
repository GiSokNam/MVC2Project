package com.mvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mvc.dao.GalleryDAO;
import com.mvc.domain.GalleryDTO;
import com.mvc.domain.PageDTO;

@Service
public class GalleryServiceImpl implements GalleryService {
	
	@Inject
	private GalleryDAO galleryDAO;

	@Override
	public List<GalleryDTO> getGalleryList(PageDTO pageDTO) {
		
		return galleryDAO.getGalleryList(pageDTO);
	}

	@Override
	public int getGalleryCount() {
		
		return galleryDAO.getGalleryCount();
	}

	@Override
	public void insertGallery(GalleryDTO galleryDTO) {
		
		galleryDAO.insertGallery(galleryDTO);
	}

	@Override
	public GalleryDTO getGallery(int num) {
		
		return galleryDAO.getGallery(num);
	}

	@Override
	public void updateGallery(GalleryDTO galleryDTO) {
		
		galleryDAO.updateGallery(galleryDTO);
	}

	@Override
	public void deleteGallery(int num) {
		
		galleryDAO.deleteGallery(num);
	}
	
	
	
}
