package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.Frame;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;
import tree.model.Workspace;

public class DeleteNodeAction extends AbstractIconAction {
	public DeleteNodeAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-delete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete (Ctrl + D)");
	}

	public void actionPerformed(ActionEvent arg0) {
		Object node = Frame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if(node!=null) {
			if(node instanceof Project) {
				((Project)(node)).removeProject();
				Frame.getInstance().getTrash().addTrash((Project)node);
			}
			else if(node instanceof Document) ((Document)(node)).removeDocument();
			else if(node instanceof Page) ((Page)(node)).removePage();
			else if(node instanceof Workspace) {
				gui.Frame.getInstance().getExceptionHandler().handleException("workspace_deleted");
			}
			SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());
		}
		else {
			gui.Frame.getInstance().getExceptionHandler().handleException("no_node_selected");
		}
	}
}
