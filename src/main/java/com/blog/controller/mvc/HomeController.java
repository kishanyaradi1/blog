package com.blog.controller.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.model.HomeModel;
import com.blog.model.URLDescriptionMapper;

@Controller
public class HomeController {

	List<String> s = Arrays.asList("java", "spring-boot");
	
	List<HomeModel> homeModels = new ArrayList<>();

	void setMap() {
		
		List<URLDescriptionMapper> utlDescs = new ArrayList<>();
		utlDescs.add(new URLDescriptionMapper("", "string"));
		HomeModel e = new HomeModel("java", utlDescs );
		
		//homeModels.add(e );
	}
	
	@RequestMapping("language/{lang}/home")
	public String homeDefault(@PathVariable(name = "lang") String lang, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("tech", s);

		return "index";
	}
	
	@RequestMapping("language/{lang}")
	public String home(@PathVariable(name = "lang") String lang, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("tech", s);

		return "index";
	}
	
	public String homeDefaultEnglish(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("tech", s);

		return "index";
	}
}
