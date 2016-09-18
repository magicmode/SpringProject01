package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVo;


@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// 01. void 리턴 타입인 경우
	@RequestMapping("doA")
	public void doA(){
		
		logger.info("doA called....................");
		
	}
	// 01. void 리턴 타입인 경우
	@RequestMapping("doB")
	public void doB(){
		
		logger.info("doB called....................");
		
	}
	
	// 02. String이 리턴 타입인 경우
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg){
		
		logger.info("doC called....................");
		
		return "doC";
	}
	
	// 03. 만들어진 결과 데이터를 전달 해야 하는 경우 
	@RequestMapping("doD")
	public String doD(Model model){
		
		ProductVo product = new ProductVo("Sample Product", 1000);
		
		logger.info("doD called");
		
		model.addAttribute(product);
		
		return "doD";
	}
		
	// 04. 리다이렉트를 해야 하는 경우
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr){
		
		rttr.addFlashAttribute("msg", "This is the Message!! with Redirectd");
		return "redirect:/doF";
	}
	
	@RequestMapping("doF")
	public void doF(String msg){
		logger.info("doF called..."+ msg);
	}
	
	@RequestMapping("doJSON")
	public @ResponseBody ProductVo doJSON(){
		
		logger.info("doJSON called");
		
		ProductVo vo = new ProductVo("샘플상품", 3000);
		
		return vo;
	}
	
}

