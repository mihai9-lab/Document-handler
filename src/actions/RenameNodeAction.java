package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.Frame;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;
import tree.model.Workspace;

public class RenameNodeAction extends AbstractIconAction {
	public RenameNodeAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-rename.png"));
		putValue(NAME, "Rename");
		putValue(SHORT_DESCRIPTION, "Rename (Ctrl + R)");
	}

	public void actionPerformed(ActionEvent arg0) {
		Object node = Frame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if(node!=null) {
			if(node instanceof Workspace) {
				gui.Frame.getInstance().getExceptionHandler().handleException("workspace_rename");
			}
			else {
				String name = JOptionPane.showInputDialog(gui.Frame.getInstance(), "New name:", node);
				if(name!=null) {
					if(node instanceof Project) ((Project)(node)).renameProject(name);
					else if(node instanceof Document) ((Document)(node)).renameDocument(name);
					else if(node instanceof Page) ((Page)(node)).renamePage(name); 
					SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());
				}
			}
		}
		else {
			gui.Frame.getInstance().getExceptionHandler().handleException("no_node_selected");
		}
	}
}
