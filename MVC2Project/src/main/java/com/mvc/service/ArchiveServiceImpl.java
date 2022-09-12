package com.mvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mvc.dao.ArchiveDAO;
import com.mvc.domain.ArchiveDTO;
import com.mvc.domain.PageDTO;

@Service
public class ArchiveServiceImpl implements ArchiveService {
	
	@Inject
	private ArchiveDAO archiveDAO;

	@Override
	public List<ArchiveDTO> getArchiveList(PageDTO pageDTO) {
		
		return archiveDAO.getArchiveList(pageDTO);
	}

	@Override
	public int getArchiveCount() {
		
		return archiveDAO.getArchiveCount();
	}

	@Override
	public void insertArchive(ArchiveDTO archiveDTO) {
		
		archiveDAO.insertArchive(archiveDTO);
	}

	@Override
	public ArchiveDTO getArchive(int num) {
		
		return archiveDAO.getArchive(num);
	}

	@Override
	public void updateArchive(ArchiveDTO archiveDTO) {
		
		archiveDAO.updateArchive(archiveDTO);
	}

	@Override
	public void deleteArchive(int num) {
		
		archiveDAO.deleteArchive(num);
	}
	
	
	
}
