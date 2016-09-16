package com.javateam.sampleprj01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormActionController {
	
	@RequestMapping("/fromSample1")
	public void formSample(){}
	
	// 01. 폼 컨트롤 ( 서블릿 방식 )
	@RequestMapping("/formAction")
	public void formAction(HttpServletRequest request,
							HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		out.println("id: " + id);
	}
	
	// 02. 폼 컨트롤 ( 어노테이션 활용 방식 - @RequestParam )
	@RequestMapping("/formActionAnn01")
	public String formAction(@RequestParam("id") String id,
							 @RequestParam("name") String name,
							 @RequestParam("address") String address){
		
		System.out.println("id: " + id);
		System.out.println("name: " + name);
		System.out.println("address: " + address);
				
		return "formAction";
	}
	
	// 03. 폼 컨트롤 ( 어노테이션 활용 방식 - @RequestParam 을  Map 형태로)
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
}
