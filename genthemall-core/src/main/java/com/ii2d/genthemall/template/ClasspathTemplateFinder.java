package com.ii2d.genthemall.template;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.DArchiveEntryWalker;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;

public class ClasspathTemplateFinder extends AbstractTemplateFinder implements
		TemplateFinder {

	private static final Log LOG = LogFactory.getLog(ClasspathTemplateFinder.class);
	
	@Override
	protected void runFinder(List<Template> templates) {
		try {
			new ClasspathFileFinder().walk(DResourceUtils
					.getResourceAsArchiveInputStream(this.getTemplatePath()),
					templates);
		} catch (IOException e) {
			throw new GenthemallException(e);
		}
	}

	protected class ClasspathFileFinder extends DArchiveEntryWalker<Template> {

		@Override
		protected void handleFile(ArchiveEntry entry,
				Collection<Template> results) {
			String name = entry.getName();
			if (name.startsWith(_getTemplatePathWithoutClasspath())) {
				Template t = new Template();
				t.setName(FilenameUtils.getName(name));
				t.setAbsolutePath("classpath:"+name);
				t.setRelativePath(name);
				t.setRelativeTargetPath(name.substring(_getTemplatePathWithoutClasspath().length()+1));
				LOG.info(String
						.format("Found a file, absolutePath: %s, relative path: %s, file name: %s, relative target path: %s",
								t.getAbsolutePath(), t.getRelativePath(),
								t.getName(), t.getRelativeTargetPath()));
				results.add(t);
			}
		}

	}

	private String templatePathWithoutClasspath;

	private String _getTemplatePathWithoutClasspath() {
		if (templatePathWithoutClasspath == null) {
			templatePathWithoutClasspath = this.getTemplatePath().substring(
					DResourceUtils.CLASSPATH_URL_PREFIX.length());
		}
		return templatePathWithoutClasspath;
	}

}
