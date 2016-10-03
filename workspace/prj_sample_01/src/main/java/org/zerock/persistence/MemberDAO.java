package org.zerock.persistence;

import org.zerock.domain.MemberVo;

public interface MemberDAO {
	public String getTime();
	public void insertMember(MemberVo vo);
}
