package gui.listeners.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class DrawingListener implements MouseListener, MouseMotionListener{
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (SwingUtilities.isLeftMouseButton(arg0))
		gui.Frame.getInstance().getIStateManager().getCurrentState().mousePressed(arg0);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		gui.Frame.getInstance().getIStateManager().getCurrentState().mouseReleased(arg0);
		
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		gui.Frame.getInstance().getIStateManager().getCurrentState().mouseDragged(arg0);
		
	}
	
}
