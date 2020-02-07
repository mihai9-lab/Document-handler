package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class RedoAction extends AbstractIconAction {
	public RedoAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/redo.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo (Ctrl + Y)");
	}

	public void actionPerformed(ActionEvent arg0) {
		gui.Frame.getInstance().getICommandManager().doCommand();
	}
}
