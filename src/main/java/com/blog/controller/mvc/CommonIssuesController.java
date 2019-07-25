package com.blog.controller.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommonIssuesController {
	
	@RequestMapping("language/{lang}/common-issues/{technology}")
	public String ciControllerList(@PathVariable(name = "lang") String lang, @PathVariable(name = "technology") String technology , Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("technology", technology);
		
		if( request.getRequestURI().contains("/common-issues/")) {
			request.getSession().setAttribute("technology",technology);
		}
		
		return "commonIssues";
	}
	
	@RequestMapping("language/{lang}/common-issues")
	public String ciControllerList1(@PathVariable(name = "lang") String lang, @PathVariable(name = "technology") String technology , Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("technology", "not selected anything!!!!");

		return "commonIssues";
	}
	
	@RequestMapping("language/{lang}/common-issues/{technology}/common-issues/{issueName}")
	public String ciControllerDetails(@PathVariable(name = "lang") String lang, @PathVariable(name = "technology") String technology, @PathVariable(name = "issueName") String issueName  , Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("issueName", issueName);

		return "commonIssues";
	}
}
