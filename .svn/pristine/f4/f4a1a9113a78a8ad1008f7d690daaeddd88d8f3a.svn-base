package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import gui.Frame;

public class CBCopyAction extends AbstractIconAction {
	public CBCopyAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy (Ctrl + C)");
	}

	public void actionPerformed(ActionEvent arg0) {
		Frame.getInstance().getClipboardManager().copy();
	}
}
