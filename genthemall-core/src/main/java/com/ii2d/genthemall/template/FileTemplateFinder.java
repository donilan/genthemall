package com.ii2d.genthemall.template;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
			ff.run(new File(this.getTemplatePath()), templates);
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
			t.setRelativePath(file.getPath());
			t.setRelativeTargetPath(file.getPath());
			t.setName(file.getName());

			// remove prefix
			if (t.getRelativePath().trim().startsWith(templatePath)) {
				t.setRelativePath(t.getRelativePath().substring(
						templatePath.length() + 1));
			}
			LOG.info(String
					.format("Found a file, absolutePath: %s, relative path: %s, file name: %s, relative target path: %s",
							t.getAbsolutePath(), t.getRelativePath(),
							t.getName(), t.getRelativeTargetPath()));
			results.add(t);
		}
	}

}
