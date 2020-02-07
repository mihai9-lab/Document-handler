package gui;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import tree.controller.WorkspaceTreeController;
import tree.view.WorkspaceTreeCellRendered;
import tree.view.WorkspaceTreeEditor;

public class WorkspaceTree extends JTree {

	public WorkspaceTree() {
		addTreeSelectionListener(new WorkspaceTreeController(this));
	    setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRendered());
	    setEditable(true);
		addMouseListener(new gui.listeners.mouse.PopupListener());
		addMouseListener(new gui.listeners.mouse.ProjectSelectionListener());
	}

}
