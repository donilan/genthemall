package com.ii2d.genthemall.source;


public abstract class AbstractSource implements Source {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
