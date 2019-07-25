package com.blog.controller.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.blog.model.NavBarModel;

@Controller
public class NavModelController {

	
	public List<NavBarModel> getNavigationDetails() {

		List<NavBarModel> navBarModels = new ArrayList<>();
		List<String> sLevel = Arrays.asList("spring boot", "spring core", "spring security", "spring repository");
		NavBarModel e = new NavBarModel("multi", "spring", sLevel);

		navBarModels.add(e);

		List<String> sLevel1 = Arrays.asList("java", "java 8", "java 9", "java 10");
		navBarModels.add(new NavBarModel("multi", "java", sLevel1));

		// navBarModels.add(new NavBarModel("single", "java"));
		navBarModels.add(new NavBarModel("single", "abap"));
		navBarModels.add(new NavBarModel("single", "maven"));

		return navBarModels;
	}

}
