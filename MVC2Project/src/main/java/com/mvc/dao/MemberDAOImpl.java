package com.mvc.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mvc.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// 마이바티스 객체생성
	@Inject
	private SqlSession sqlSession;
		
	// memberMapper파일에 정의된 전체 이름을 변수에 저장
	private static final String namespace = "com.mvc.mappers.memberMapper";

	@Override
	public MemberDTO getMember(String id) {
		// DB작업
		return sqlSession.selectOne(namespace+".getMember", id);
	}

	@Override
	public void insertMember(MemberDTO memberDTO) {
		// DB작업
		sqlSession.insert(namespace+".insertMember", memberDTO);
		
	}

	@Override
	public MemberDTO userCheck(MemberDTO memberDTO) {
		// DB작업
		return sqlSession.selectOne(namespace+".userCheck", memberDTO);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) {
		// DB작업
		sqlSession.update(namespace+".updateMember", memberDTO);
	}

	@Override
	public void deleteMember(MemberDTO memberDTO) {
		// DB작업
		sqlSession.delete(namespace+".deleteMember", memberDTO);
		
	}
	
	
	
	
}
