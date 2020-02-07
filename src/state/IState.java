package state;

import java.awt.event.MouseEvent;

public interface IState {
	public void mousePressed(MouseEvent e);
	public void mouseDragged(MouseEvent e);
	public void mouseReleased(MouseEvent e);
}
