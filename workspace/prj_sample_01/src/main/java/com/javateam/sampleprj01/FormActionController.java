package com.javateam.sampleprj01;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javateam.model.Member;

@Controller
public class FormActionController {
	
	@RequestMapping("/fromSample1")
	public void formSample(){}
	
	// 01. 폼 컨트롤 ( 서블릿 방식 )!
	@RequestMapping("/formAction2")
	public String formAction(HttpServletRequest request,
							HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		
		//PrintWriter out = response.getWriter();
		//out.println("id: " + id);
		
		// Object 타입
		request.setAttribute("id", id);
		request.setAttribute("id2", id);
		
		return "formAction2";
	}
	
	// 02. 폼 컨트롤 ( 어노테이션 방식 - @RequestParam )!
	@RequestMapping("/formActionAnn01")
	public String formAction(@RequestParam("id") String id,
							 @RequestParam("name") String name,
							 @RequestParam("address") String address){
		
		System.out.println("id: " + id);
		System.out.println("name: " + name);
		System.out.println("address: " + address);
				
		return "formAction";
	}
	
	// 03. 폼 컨트롤 ( 어노테이션 방식 - @RequestParam 의  Map 활용)!
	@RequestMapping("/formActionAnn02")
	public String formAction(@RequestParam Map<String,String> params){
		
		
		System.out.println("entrySet() : " + params.entrySet());
		System.out.println("toString() : " +params.toString());
		
		Set<Entry<String,String>> set =params.entrySet();
		
		// 이터레이터 포 루프
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, String> entry = (Entry<String, String>) iterator.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
		// 인헤스트 포 루프
		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
//		System.out.println("id: " + params.get("id"));
//		System.out.println("name: " + params.get("name"));
//		System.out.println("address: " + params.get("address"));
				
		return "formAction";
	}
	
	// 04. 폼 컨트롤 ( Pure POJO 모델 방식  )!
	@RequestMapping("/formActionModel01")
	public String formActionModel01(Member member){
		
		System.out.println("member id: " + member.getId());
		System.out.println("member name: " + member.getName());
		System.out.println("member address: " + member.getAddress());
		
		return "formAction";
	}
	
	// 05. 폼 컨트롤 ( @ModelAttribute POJO 모델 방식  )!
	@RequestMapping("/formActionModel02")
	public String formActionModel02(@ModelAttribute Member member, BindingResult result){
		
		// form validation ( 폼 정검 )
		// 하이버네이트 JSR-303
		if(result.hasErrors()){
			System.out.println("Binding Failed");
			return "fromSample1";
		}else{
			System.out.println("member id: " + member.getId());
			System.out.println("member name: " + member.getName());
			System.out.println("member address: " + member.getAddress());
		}
		
		return "formAction";
	}
	
	// 06. View 인자 넘기기 ( ui.Model 객체 활용하는 방식 )!
	@RequestMapping("/formActionModel03")
	public String formActionModel03(@RequestParam("id") String id,
			                        Model model,
			                        HttpServletRequest request){
		
		model.addAttribute("id",id);
		request.setAttribute("id2", id);
		
		return "formAction2";
	}	

	// 07. View 인자 넘기기 ( ModelAndView 객체 활용하는 방식 )!
	@RequestMapping("/formActionModelAndView")
	public ModelAndView formActionModelAndView(@RequestParam("id") String id){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		
		return modelAndView;
	}
	
	// 08.폼 컨트롤  ( @RequestBody ) 
	@RequestMapping("/formActionBody")
	public void formActionBody(@RequestBody String body){
		
		System.out.println(body);
		String str[] = body.split("&");
		
		// 이니스트 포 루프
		for (String string : str) {
			System.out.println(string);
		}
	}
	
	// 09.폼 컨트롤  ( @RequestHeader ) 
	@RequestMapping("/formActionHeader")
	public void formActionHeader(@RequestHeader(value="Accept-Language", required=false, defaultValue="ko") String header){
		
		System.out.println(header);
	}	
}
