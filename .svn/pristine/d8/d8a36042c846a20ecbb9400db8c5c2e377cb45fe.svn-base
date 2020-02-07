package actions;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.Frame;

public class CBCutAction extends AbstractIconAction {

	
	public CBCutAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-cut.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut (Ctrl + X)");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Frame.getInstance().getClipboardManager().cut();
			SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());	
		} catch (UnsupportedFlavorException | IOException e1) {
			gui.Frame.getInstance().getExceptionHandler().handleException("unknown_error");
		}
		
	}

}
