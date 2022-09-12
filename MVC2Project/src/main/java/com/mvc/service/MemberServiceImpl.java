package com.mvc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mvc.dao.MemberDAO;
import com.mvc.domain.MemberDTO;

//클래스에서 클래스 상속 extends
//클래스에서 인터페이스 상속 implements
@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	
	@Override
	public MemberDTO getMember(String id) {
		// 메서드 호출
		return memberDAO.getMember(id);
	}

	
	@Override
	public void insertMember(MemberDTO memberDTO) {
		
		// 메서드 호출
		memberDAO.insertMember(memberDTO);
	}


	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		// 메서드 호출
		return memberDAO.userCheck(memberDTO);
	}


	@Override
	public void updateMember(MemberDTO memberDTO) {
		// 메서드 호출
		memberDAO.updateMember(memberDTO);
	}


	@Override
	public void deleteMember(MemberDTO memberDTO) {
		// 메서드 호출
		memberDAO.deleteMember(memberDTO);
	}
	
	

	
	
	
	
	
	
	
}
