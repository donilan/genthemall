package com.ii2d.genthemall;


import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

public class Generator {
	
	private Writer out;
	private String templateText;
	private Map<?, ?> binding;
	
	public void generate() throws CompilationFailedException, ClassNotFoundException, IOException {
		SimpleTemplateEngine engine = new SimpleTemplateEngine();
		Template t = engine.createTemplate(templateText.trim());
		t.make(binding).writeTo(out);
	}


	public Writer getOut() {
		return out;
	}


	public void setOut(Writer out) {
		this.out = out;
	}


	public String getTemplateText() {
		return templateText;
	}


	public void setTemplateText(String templateText) {
		this.templateText = templateText;
	}


	public Map<?, ?> getBinding() {
		return binding;
	}


	public void setBinding(Map<?, ?> binding) {
		this.binding = binding;
	}

	
}
