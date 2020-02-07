package actions;

import java.awt.event.ActionEvent;

public class DrawRectangleAction extends AbstractIconAction{

	public DrawRectangleAction() {
		putValue(SMALL_ICON, loadIcon("images/draw-rectangle.png"));
		putValue(NAME, "Draw Rectangle");
		putValue(SHORT_DESCRIPTION, "Draw Rectangle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setRectangleState();
	}
}
