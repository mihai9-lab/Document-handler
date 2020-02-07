package actions;

import java.awt.event.ActionEvent;

public class RotateAndScaleAction extends AbstractIconAction{

	public RotateAndScaleAction() {
		putValue(SMALL_ICON, loadIcon("images/rotate-and-scale-shape.png"));
		putValue(NAME, "Rotate And Scale Shape");
		putValue(SHORT_DESCRIPTION, "Rotate And Scale Shape");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.Frame.getInstance().getIStateManager().setRotateAndScaleState();
	}
}
