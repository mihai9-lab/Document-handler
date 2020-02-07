package tree.view;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import gui.WorkspaceTree;
import tree.controller.RenameAction;
import tree.model.Workspace;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor{
	
	private JTextField edit;
	
	public WorkspaceTreeEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}
	
	public Component getTreeCellEditorComponent(JTree arg0, Object value, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        
        edit = new JTextField(value.toString());
        edit.addActionListener(new RenameAction(value));
		return edit;
	}
	
	public boolean isCellEditable(EventObject arg0) {
		Object o = ((WorkspaceTree) arg0.getSource()).getLastSelectedPathComponent();
		
		if (arg0 instanceof MouseEvent && !(o instanceof Workspace))
			if (((MouseEvent)arg0).getClickCount()==3) return true;
				
		return false;
	}
}