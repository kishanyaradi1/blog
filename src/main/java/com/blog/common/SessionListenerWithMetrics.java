package com.blog.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.controller.common.NavModelController;
import com.blog.model.NavBarModel;

import lombok.Getter;
import lombok.Setter;

@WebListener
@Getter
@Setter
public class SessionListenerWithMetrics implements HttpSessionListener {

	private final AtomicInteger activeSessions;
	List<String> techs = new ArrayList();

	NavBarModel navBarModel;

	@Autowired
	NavModelController navModelController;
	
	@Autowired
	SessionValues sessionValues;

	List<NavBarModel> navBarModels = new ArrayList<>();

	public SessionListenerWithMetrics() {
		super();

		activeSessions = new AtomicInteger();
	}

	public int getTotalActiveSession() {
		return activeSessions.get();
	}

	public void sessionCreated(final HttpSessionEvent event) {
		
		event.getSession().setAttribute("navBars", navModelController.getNavigationDetails());

		activeSessions.incrementAndGet();
	}


	public void sessionDestroyed(final HttpSessionEvent event) {
		activeSessions.decrementAndGet();
	}
}