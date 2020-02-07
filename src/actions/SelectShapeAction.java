package actions;

import java.awt.event.ActionEvent;

public class SelectShapeAction extends AbstractIconAction{

	public SelectShapeAction() {
		putValue(SMALL_ICON, loadIcon("images/select-shape.png"));
		putValue(NAME, "Select Shape");
		putValue(SHORT_DESCRIPTION, "Select Shape");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setSelectState();
	}
}
