package directory.browser.file.filters;

import java.io.File;

public class WorkspaceFileFilter  extends AbstractFileFilter {

	@Override
	public boolean accept(File f) {
		
		if(f.isDirectory())
			return true;
		if(f.getName().toLowerCase().endsWith(".gwf"))
			return true;
		
		return false;
		
	}

	@Override
	public String getDescription() {
		return "GeRuDok Workspace File .gwf";
	}

	@Override
	public String getExtension() {
		return ".gwf";
	}

}
