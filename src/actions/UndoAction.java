package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class UndoAction extends AbstractIconAction {
	public UndoAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/undo.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo (Ctrl + Z)");
	}

	public void actionPerformed(ActionEvent arg0) {
		gui.Frame.getInstance().getICommandManager().undoCommand();
	}
}
