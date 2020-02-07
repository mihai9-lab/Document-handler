package directory.browser.file.filters;

import java.io.File;

public class DocumentFileFilter extends AbstractFileFilter {

	@Override
	public boolean accept(File f) {
		
		if(f.isDirectory())
			return true;
		if(f.getName().toLowerCase().endsWith(".gdf"))
			return true;
		
		return false;
		
	}

	@Override
	public String getDescription() {
		return "GeRuDok Document File .gdf";
	}

	@Override
	public String getExtension() {
		return ".gdf";
	}
}
