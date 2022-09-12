package com.mvc.dao;

import java.util.List;

import com.mvc.domain.GalleryDTO;
import com.mvc.domain.PageDTO;

public interface GalleryDAO {

	List<GalleryDTO> getGalleryList(PageDTO pageDTO);

	int getGalleryCount();

	void insertGallery(GalleryDTO galleryDTO);

	GalleryDTO getGallery(int num);

	void updateGallery(GalleryDTO galleryDTO);

	void deleteGallery(int num);
	
	

}
