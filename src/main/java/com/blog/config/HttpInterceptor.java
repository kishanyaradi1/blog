package com.blog.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.blog.common.SessionValues;
import com.blog.controller.common.NavModelController;
import com.blog.model.NavBarModel;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class HttpInterceptor implements HandlerInterceptor {

	@Autowired
	SessionValues sessionValue;

	List<NavBarModel> navBarModels = new ArrayList<>();

	@Autowired
	NavModelController navModelController;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		log.info("Request Completed!");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
		log.info("Method executed");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		// request.getSession().setAttribute("lang","en");

		String[] split = request.getRequestURI().split("/");

		String lang = null;

		if ("language".equals(split[0])) {
			lang = split[1];
		} else if ("language".equals(split[1])) {
			lang = split[2];
		} else {
			lang = "en";
		}

		request.getSession().setAttribute("lang", lang);
		if (!lang.equals(sessionValue.getLanguage())) {
			String lang1 = lang;
			// Locale.getAvailableLocales()

			Locale effectiveLocale = Arrays.stream(Locale.getAvailableLocales())
					.filter(locale -> lang1.equals(locale.getLanguage())).findFirst().orElseGet(Locale::getDefault);

			ResourceBundle message = ResourceBundle.getBundle("locale.message", effectiveLocale);

			sessionValue.setEffectiveLocale(effectiveLocale);
			sessionValue.setLanguage(lang);
			sessionValue.setMessage(message);

		}

		if (request.getSession().getAttribute("navBars") == null) {			
			request.getSession().setAttribute("navBars", navModelController.getNavigationDetails());
		}

		// if("language".equals(split[0])) {
		// request.getSession().setAttribute("lang",split[1]);
		// } else if("language".equals(split[1])){
		// request.getSession().setAttribute("lang",split[2]);
		// }

		return true;
	}
}