package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.Frame;
import tree.model.ITreeNodeSerialization;

public class SaveNodeAction extends AbstractIconAction{

	public SaveNodeAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-save.png"));
		putValue(NAME, "Save");
		putValue(SHORT_DESCRIPTION, "Save (Ctrl + S)");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object node = Frame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

		if(node==null) {
			gui.Frame.getInstance().getExceptionHandler().handleException("no_node_selected");
			return;
		}
		if(node instanceof tree.model.Page) {
			gui.Frame.getInstance().getExceptionHandler().handleException("page_saved");
			return;
		}

		Frame.getInstance().getSerialiser().save((ITreeNodeSerialization)node);
	}
}
