package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import tree.model.Document;

public class ShareAction extends AbstractIconAction {

	public ShareAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-share.png"));
		putValue(NAME, "Share");
		putValue(SHORT_DESCRIPTION, "Share (Ctrl + P)");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TreeNode node = (TreeNode) gui.Frame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		if(node instanceof Document)
			((Document)node).share();
		SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());
	}
}
