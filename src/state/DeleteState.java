package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import command.DeleteCommand;
import tree.model.Page;
import tree.model.PageSelectedSlots;
import tree.model.Slot;
import view.PageView;

public class DeleteState implements IState {
	
	private Point pos;
	private Page p;
	
	public void mousePressed(MouseEvent e){
		pos=e.getPoint();
		p=((PageView)e.getComponent()).getPage();
		p.getPageSelectedSlots().addObserver((PageView)e.getComponent());
		p.getPageSelectedSlots().clearSelection();
		p.getPageSelectedSlots().setDeletion(true);
	}
	
	public void mouseDragged(MouseEvent e){
		if(p!=null && p==((PageView)e.getComponent()).getPage()) {
			PageSelectedSlots ps = p.getPageSelectedSlots();
			ps.clearSelection();
			int c = p.getSlotsCount();
			for(int i=0;i<c;i++) {
				Slot s = p.getSlot(i);
				double xCenter = s.getGeometry().getXCenter();
				double yCenter = s.getGeometry().getYCenter();
				if(xCenter>=Math.min(pos.x,e.getX()) && xCenter<=Math.max(pos.x,e.getX()) && yCenter>=Math.min(pos.y,e.getY()) && yCenter<=Math.max(pos.y,e.getY())) {
					ps.addSlot(s);
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		if(p!=null && p==((PageView)e.getComponent()).getPage()) {
			PageSelectedSlots ps = p.getPageSelectedSlots();
			ps.clearSelection();
			int c = p.getSlotsCount();
			for(int i=0;i<c;i++) {
				Slot s = p.getSlot(i);
				double xCenter = s.getGeometry().getXCenter();
				double yCenter = s.getGeometry().getYCenter();
				if(xCenter>=Math.min(pos.x,e.getX()) && xCenter<=Math.max(pos.x,e.getX()) && yCenter>=Math.min(pos.y,e.getY()) && yCenter<=Math.max(pos.y,e.getY())) {
					ps.addSlot(s);
				}
			}
			if(ps.getSelectedCount()>0) gui.Frame.getInstance().getICommandManager().addCommand(new DeleteCommand(p,ps));
		}
		
	}
	
}
