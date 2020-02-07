package actions;

import java.awt.event.ActionEvent;

public class DrawTriangleAction extends AbstractIconAction{

	public DrawTriangleAction() {
		putValue(SMALL_ICON, loadIcon("images/draw-triangle.png"));
		putValue(NAME, "Draw Triangle");
		putValue(SHORT_DESCRIPTION, "Draw Triangle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setTriangleState();
	}
}
