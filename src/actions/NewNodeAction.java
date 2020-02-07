package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import gui.Frame;
import node.factory.DocumentFactory;
import node.factory.NodeFactory;
import node.factory.PageFactory;
import node.factory.ProjectFactory;
import tree.model.Project;
import tree.model.Workspace;
import tree.model.Document;
import tree.model.INode;
import tree.model.Page;
public class NewNodeAction extends AbstractIconAction {
	
	public NewNodeAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-new.png"));
		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "New (Ctrl + N)");
	}

	public void actionPerformed(ActionEvent arg0) {
		
		TreeNode node = (TreeNode)Frame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		if(node==null) {
			gui.Frame.getInstance().getExceptionHandler().handleException("no_node_selected");
			return;
		}
		if(node instanceof Page) {
			gui.Frame.getInstance().getExceptionHandler().handleException("page_child");
			return;
		}
		
		NodeFactory factory = getNodeFactory(node);
		
		((INode)node).add(factory.createNode());
		
		
		SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());
		
	}
	private static NodeFactory getNodeFactory(TreeNode node) {
		
		if(node instanceof Workspace) 
			return new ProjectFactory();
		else if(node instanceof Project)
			return new DocumentFactory();
		else if(node instanceof Document)
			return new PageFactory();
		else
			return null;
	}
	
	/*private void addNode(TreeNode parent,TreeNode node) {
		if(node instanceof Project)
			((Workspace)parent).addProject((Project)node);
		else if(node instanceof Document)
			((Project)parent).addDocument((Document)node);
		else if(node instanceof Page)
			((Document)parent).addPage((Page)node);
	}*/

}
