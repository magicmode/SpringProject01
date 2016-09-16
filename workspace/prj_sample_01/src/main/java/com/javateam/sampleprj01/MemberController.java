package com.javateam.sampleprj01;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javateam.model.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/viewMember")
	public void viewMember(){
		System.out.println("viewMember");
	}
	
	@RequestMapping("/updateMember")
	public void updateMember(){
		System.out.println("updateMember");
	}
	
	@RequestMapping("/joinMember")
	public void joinMember(Member member){
		
	}
	
	@RequestMapping("/join")
	public String join(@Valid Member member,BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("binding Error");
			return "/member/joinMember";
		}else{
			System.out.println(member.getId());
			return "/member/join";
		}
		
	}
}
