package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVo;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE="org.zerock.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE+".getTime");
	}

	@Override
	public void insertMember(MemberVo vo) {
		sqlSession.insert(NAMESPACE+".insertMember",vo);		
	}

}
