package gui.listeners.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import tree.model.Page;
import view.MiniPageView;

public class PageSelectionListener implements MouseListener{

	public void mouseClicked(MouseEvent arg0) {
		Page p = ((MiniPageView)arg0.getComponent()).getPage();
		if(!p.isSelected()) p.select();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
