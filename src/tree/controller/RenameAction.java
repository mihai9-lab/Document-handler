package tree.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import tree.model.Document;
import tree.model.Page;
import tree.model.Project;

public class RenameAction implements ActionListener {

	Object node;
	
	public RenameAction(Object node) {
		this.node=node;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(node instanceof Project) ((Project)(node)).renameProject(e.getActionCommand());
		else if(node instanceof Document) ((Document)(node)).renameDocument(e.getActionCommand());
		else if(node instanceof Page) ((Page)(node)).renamePage(e.getActionCommand());
		SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());
		
	}
	

}
