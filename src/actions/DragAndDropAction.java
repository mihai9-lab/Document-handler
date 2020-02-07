package actions;

import java.awt.event.ActionEvent;

public class DragAndDropAction extends AbstractIconAction{

	public DragAndDropAction() {
		putValue(SMALL_ICON, loadIcon("images/drag-and-drop-shape.png"));
		putValue(NAME, "Drag and Drop Shape");
		putValue(SHORT_DESCRIPTION, "Drag and Drop Shape");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setDragAndDropState();
	}
}
