package com.mvc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mvc.dao.NoticeDAO;
import com.mvc.domain.NoticeDTO;
import com.mvc.domain.PageDTO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;

	@Override
	public List<NoticeDTO> getNoticeList(PageDTO pageDTO) {
		
		return noticeDAO.getNoticeList(pageDTO);
	}

	@Override
	public int getNoticeCount() {
		
		return noticeDAO.getNoticeCount();
	}

	@Override
	public void insertNotice(NoticeDTO noticeDTO) {
		
		noticeDAO.insertNotice(noticeDTO);
	}

	@Override
	public NoticeDTO getNotice(int num) {
		
		return noticeDAO.getNotice(num);
	}

	@Override
	public void updateNotice(NoticeDTO noticeDTO) {
		
		noticeDAO.updateNotice(noticeDTO);
	}

	@Override
	public void deleteNotice(int num) {
		
		noticeDAO.deleteNotice(num);
	}
	
	
	
}
