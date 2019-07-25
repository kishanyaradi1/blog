package com.blog.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NavBarModel {
	//single,multi 
	String type;
	String fLevel;
	List<String> sLevel = new ArrayList<>();

	public NavBarModel(String type, String fLevel) {
		super();
		this.type = type;
		this.fLevel = fLevel;
	}

}
