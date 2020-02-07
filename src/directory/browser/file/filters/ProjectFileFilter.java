package directory.browser.file.filters;

import java.io.File;

public class ProjectFileFilter extends AbstractFileFilter{

	@Override
	public boolean accept(File f) {
		
		if(f.isDirectory())
			return true;
		if(f.getName().toLowerCase().endsWith(".gpf"))
			return true;
		
		return false;
		
	}

	@Override
	public String getDescription() {
		return "GeRuDok Project File .gpf";
	}

	@Override
	public String getExtension() {
		return ".gpf";
	}
}
