package com.javateam.sampleprj01;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVo;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime(){
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember(){
		
		MemberVo vo = new MemberVo();
		vo.setUserid("user01");
		vo.setUserpw("user01");
		vo.setUsername("user01");
		vo.setEmail("user01@aaa.com");
		
		dao.insertMember(vo);
	}
}
