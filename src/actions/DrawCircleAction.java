package actions;

import java.awt.event.ActionEvent;

public class DrawCircleAction extends AbstractIconAction{

	public DrawCircleAction() {
		putValue(SMALL_ICON, loadIcon("images/draw-circle.png"));
		putValue(NAME, "Draw Circle");
		putValue(SHORT_DESCRIPTION, "Draw Circle");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setCircleState();
	}
}
