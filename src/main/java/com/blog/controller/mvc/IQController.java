package com.blog.controller.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IQController {
	
	@RequestMapping("language/{lang}/interview-questions/{technology}")
	public String List(@PathVariable(name = "lang") String lang, @PathVariable(name = "technology") String technology , Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("technology", technology);
		
		
		
		return "InterviewQuestions";
	}
	
	@RequestMapping("language/{lang}/interview-questions/{technology}/common-issues/{issueName}")
	public String ciControllerDetails(@PathVariable(name = "lang") String lang, @PathVariable(name = "technology") String technology, @PathVariable(name = "issueName") String issueName  , Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("issueName", issueName);

		return "InterviewQuestions";
	}
}
