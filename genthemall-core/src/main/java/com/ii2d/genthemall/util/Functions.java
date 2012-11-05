package com.ii2d.genthemall.util;

import org.apache.commons.lang3.StringUtils;

public class Functions {
	
	/**
	 * Choice an option that first not blank.
	 * @author Doni
	 * @since 2012-11-2
	 * @param opts
	 */
	public static String choiceOne(Object... opts) {
		for(Object o: opts) {
			if(o != null && StringUtils.isNotBlank(o.toString()))
				return o.toString();
		}
		return "";
	}
}
