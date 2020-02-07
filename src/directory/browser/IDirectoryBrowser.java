package directory.browser;

import java.io.File;

import tree.model.ITreeNodeSerialization;

public interface IDirectoryBrowser {
	
	public File getSaveLocation(ITreeNodeSerialization node);
	public File getOpenLocation();
	public File getWorkspaceLocation();
}
