package tree.model;

import java.io.File;

public interface ITreeNodeSerialization {
	
	public void setLoaction(File f);
	public File getLocation();
	public void setChanged(boolean changed);
	public boolean isChanged();
	public String toString();
}
