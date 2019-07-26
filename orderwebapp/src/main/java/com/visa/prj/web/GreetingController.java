package com.visa.prj.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
	
	@RequestMapping(value="greeting.do")
	public ModelAndView getGreeting() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Good day!");
		mav.addObject("date",new Date());
		mav.setViewName("greet.jsp");
		return mav;
	}
	

}
