package com.javateam.sampleprj01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
