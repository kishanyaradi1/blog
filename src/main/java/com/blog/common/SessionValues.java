package com.blog.common;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.blog.model.NavBarModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SessionScope
@Component
public class SessionValues {

	String language;

	Locale effectiveLocale;

	ResourceBundle message;
	
	String technology;

	
	public Map<String, String> getLocalisedStrings(Collection<String> nutrition) {
		return nutrition.stream().collect(Collectors.toConcurrentMap(s -> s, s -> getMessage().getString(s)));
	}


	public String getProperty(final String key){
		return message.getString(key);
	}
	
	public Integer getPropertyInt(final String key){
		return Integer.parseInt(message.getString(key).trim());
	}	
	
	public String getProperty(final String key, final Object ...values){
		final String pattern = message.getString(key);
		return MessageFormat.format(pattern, values);
	}


	public SessionValues() {
		super();
		
		
	}
	
}
