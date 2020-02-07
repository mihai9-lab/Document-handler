package tree.model;

import javax.swing.tree.DefaultTreeModel;

public class WorkspaceModel extends DefaultTreeModel {
	
	
	public WorkspaceModel() {
		super(new Workspace());
	}
	public WorkspaceModel(Workspace ws) {
		super(ws);
	}
}
