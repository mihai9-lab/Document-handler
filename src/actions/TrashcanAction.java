package actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import gui.Frame;

public class TrashcanAction extends AbstractIconAction{

	public TrashcanAction() {
		putValue(SMALL_ICON, loadIcon("images/palettebar-trash.png"));
		putValue(NAME, "Trashcan");
		putValue(SHORT_DESCRIPTION, "Open Trashcan");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame.getInstance().getTrash().getDocument();
		SwingUtilities.updateComponentTreeUI(gui.Frame.getInstance().getWorkspaceTree());
	}
}
