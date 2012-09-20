package com.ii2d.genthemall.template;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.dbase.util.DFileNameUtils;
import com.ii2d.dbase.util.DResourceUtils;
import com.ii2d.genthemall.exception.GenthemallException;

/**
 * Template finder
 * 
 * @author Doni
 * @since 2012-9-10
 * @version $id$
 */
public class FileTemplateFinder extends AbstractTemplateFinder implements
		TemplateFinder {

	private static final Log LOG = LogFactory.getLog(FileTemplateFinder.class);

	@Override
	protected void runFinder(List<Template> templates) {
		FileFinder ff = new FileFinder();
		try {
			ff.run(DResourceUtils.getResourceAsFile(this.getTemplatePath()),
					templates);
		} catch (IOException e) {
			throw new GenthemallException(e);
		}
	}

	/**
	 * File finder
	 * 
	 * @author Doni
	 * @since 2012-9-11
	 * @version $id$
	 */
	protected class FileFinder extends DirectoryWalker<Template> {

		public void run(File f, Collection<Template> results)
				throws IOException {
			walk(f, results);
		}

		@Override
		protected void handleFile(File file, int depth,
				Collection<Template> results) throws IOException {
			Template t = new Template();
			t.setAbsolutePath(file.getAbsolutePath());
			t.setRelativeTargetPath(DFileNameUtils.removePath(file.getPath(), getTemplatePath()));
			t.setName(file.getName());
			LOG.info(String
					.format("Found a file, absolutePath: %s, file name: %s, relative targe path: %s",
							t.getAbsolutePath(),
							t.getName(), t.getRelativeTargetPath()));
			results.add(t);
		}

	}

}
