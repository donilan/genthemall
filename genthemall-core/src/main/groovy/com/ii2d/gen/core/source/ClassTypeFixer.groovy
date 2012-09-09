package com.ii2d.gen.core.source

class ClassTypeFixer {
	Map fixer = [:]
	
	public ClassTypeFixer(){}
	
	public ClassTypeFixer(Map fixer) {
		this.fixer = fixer
	}
	
	public String fix(String type) {
		return fixer[type]?: type	
	}
}
