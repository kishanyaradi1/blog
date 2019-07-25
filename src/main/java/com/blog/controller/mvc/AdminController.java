package com.blog.controller.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.model.NavigationModel;

@Controller
public class AdminController {
	
	
	@ModelAttribute("navigation")
	public NavigationModel constructNutrition() {
		return new NavigationModel();
	}
	
	
	@RequestMapping("language/{lang}/admin")
	public String admin(@PathVariable(name = "lang") String lang, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("technology", "admin");

		return "admin";
	}

	@RequestMapping("language/{lang}/admin/create-blog")
	public String adminCreateBlog(@PathVariable(name = "lang") String lang, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("technology", "admin");
		model.addAttribute("selectedTab", "create");
		return "admin";
	}

	@RequestMapping("language/{lang}/admin/edit-blog")
	public String adminEditBlog(@PathVariable(name = "lang") String lang, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("technology", "admin");
		model.addAttribute("selectedTab", "edit");
		return "admin";
	}

	@RequestMapping("language/{lang}/admin/add-navigation")
	public String readAdminNavigation(@PathVariable(name = "lang") String lang, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("technology", "admin");
		model.addAttribute("selectedTab", "edit");
		return "admin";
	}

	@RequestMapping(value = "language/{lang}/admin/add-navigation", method = RequestMethod.POST)
	public String addadminNavigation(@PathVariable(name = "lang") String lang, Model model, @ModelAttribute("navigation") NavigationModel navigationModel , HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("technology", "admin");
		model.addAttribute("selectedTab", "edit");
		return "admin";
	}
}
