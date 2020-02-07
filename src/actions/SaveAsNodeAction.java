package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.KeyStroke;

import gui.Frame;
import tree.model.ITreeNodeSerialization;

public class SaveAsNodeAction extends AbstractIconAction {

	public SaveAsNodeAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-saveas.png"));
		putValue(NAME, "Save As");
		putValue(SHORT_DESCRIPTION, "Save As(Shift + S)");
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
		ITreeNodeSerialization n = (ITreeNodeSerialization) node;
		File f = n.getLocation();
		File k = null;
		n.setLoaction(k);
		n.setChanged(true);
		Frame.getInstance().getSerialiser().save(n);
		if(n.getLocation()==null)
			n.setLoaction(f);
	}
}

