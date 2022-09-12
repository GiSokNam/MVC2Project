package com.mvc.dao;

import com.mvc.domain.MemberDTO;

public interface MemberDAO {
	
	// 공통된 틀 정의
	// 추상메서드 (메서드 틀)
	// 상속 받는 모든 클래스들은 똑같은 메서드를 사용 가능
	MemberDTO getMember(String id);
		
	void insertMember(MemberDTO memberDTO);

	MemberDTO userCheck(MemberDTO memberDTO);

	void updateMember(MemberDTO memberDTO);

	void deleteMember(MemberDTO memberDTO);

	
	

}
