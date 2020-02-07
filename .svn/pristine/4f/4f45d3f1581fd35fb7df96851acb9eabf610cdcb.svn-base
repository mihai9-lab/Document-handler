package gui.listeners.mouse;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import gui.Frame;
import tree.model.Page;
import tree.model.Slot;
import view.PageView;

public class SlotPopupListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (SwingUtilities.isRightMouseButton(e)){
			Page p = ((PageView)e.getComponent()).getPage();
			Slot s = p.contains(e.getPoint());
			if(s==null)
				return;
			p.getPageSelectedSlots().setEditingSlot(s);
			
			JPopupMenu popup = new JPopupMenu();
			if(s.getElement()==null) {
				popup.add(gui.Frame.getInstance().getActionManager().getTextElementAction());
			    popup.add(gui.Frame.getInstance().getActionManager().getPictureElementAction());
			}
			else
				popup.add(gui.Frame.getInstance().getActionManager().getEditSlotElementAction());
		    popup.show(e.getComponent(), e.getX(), e.getY());  
		}
		
		
		else if (e.getClickCount()==2) {
			Page p = ((PageView)e.getComponent()).getPage();
			Slot s = p.contains(e.getPoint());
			if(s==null)
				return;
		}
			
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
