package com.mvc.service;

import java.util.List;

import com.mvc.domain.ArchiveDTO;
import com.mvc.domain.PageDTO;

public interface ArchiveService {

	List<ArchiveDTO> getArchiveList(PageDTO pageDTO);
	
	int getArchiveCount();

	void insertArchive(ArchiveDTO archiveDTO);

	ArchiveDTO getArchive(int num);

	void updateArchive(ArchiveDTO archiveDTO);

	void deleteArchive(int num);

	


}
