package com.ii2d.genthemall;

import org.apache.commons.lang3.StringUtils;

/**
 * Generate the config file.
 * @author Doni
 * @since 2012-9-11
 * @version $id$
 */
public class Source2ConfigGenerator extends SourceGenerator {

	public static final String DEFAULT_TARGET = "genthemall.conf.groovy";
	private static final String DEFAULT_TEMPLATE = "classpath:com/ii2d/genthemall/template/core/conf/config.template";

	public Source2ConfigGenerator() {
		super();
		this.setTargetFile(DEFAULT_TARGET);
	}

	@Override
	public String getTemplatePath() {
		return StringUtils.isBlank(super.getTemplatePath()) ? DEFAULT_TEMPLATE
				: super.getTemplatePath();
	}

}
