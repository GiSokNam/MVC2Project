package com.mvc.service;

import java.util.List;

import com.mvc.domain.NoticeDTO;
import com.mvc.domain.PageDTO;

public interface NoticeService {

	List<NoticeDTO> getNoticeList(PageDTO pageDTO);
	
	int getNoticeCount();

	void insertNotice(NoticeDTO noticeDTO);

	NoticeDTO getNotice(int num);

	void updateNotice(NoticeDTO noticeDTO);

	void deleteNotice(int num);

	


}
