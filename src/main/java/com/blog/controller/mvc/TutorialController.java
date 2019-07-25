package com.blog.controller.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorialController {

	@RequestMapping("language/{lang}/tutorial/{technology}")
	public String tutorialList(@PathVariable(name = "lang") String lang,
			@PathVariable(name = "technology") String technology, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("technology", technology);

		return "tutorial";
	}
	

	@RequestMapping("language/{lang}/tutorial/{technology}/{tutorialContent}")
	public String tutorialDetails(@PathVariable(name = "lang") String lang,
			@PathVariable(name = "technology") String technology,
			@PathVariable(name = "tutorialContent") String tutorialContent, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("tutorialContent", tutorialContent);

		return "tutorial";
	}

}
