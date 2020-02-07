package directory.browser.file.filters;

import java.io.File;

public class GerudokFileFilter extends AbstractFileFilter {

	@Override
	public String getExtension() {
		return null;
	}

	@Override
	public boolean accept(File f) {

		if(f.isDirectory())
			return true;
		if(f.getName().toLowerCase().endsWith(".gwf") || f.getName().toLowerCase().endsWith(".gpf") || f.getName().toLowerCase().endsWith(".gdf"))
			return true;
		
		return false;
	}

	@Override
	public String getDescription() {
		return "GeRuDok Files (*.gwf, *.gpf, *.gdf)";
	}

}
