package actions;

import java.awt.event.ActionEvent;

public class DeleteSlotAction extends AbstractIconAction{

	public DeleteSlotAction() {
		putValue(SMALL_ICON, loadIcon("images/palette-delete.png"));
		putValue(NAME, "Delete Shape");
		putValue(SHORT_DESCRIPTION, "Delete Shape");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setDeleteState();
	}
}
