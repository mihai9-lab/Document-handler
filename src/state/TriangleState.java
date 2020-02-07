package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import command.AddSlotCommand;
import tree.model.Page;
import tree.model.Slot;
import tree.model.geometry.TriangleGeometry;
import view.PageView;

public class TriangleState implements IState {
	private Point pos;
	private Page p;
	private Slot s;
	
	public void mousePressed(MouseEvent e){
		pos=e.getPoint();
		p=((PageView)e.getComponent()).getPage();
		p.addSlot(new Slot(new TriangleGeometry(pos.getX(),pos.getY(),1,0)));
		p.getPageSelectedSlots().clearSelection();
	}
	
	public void mouseDragged(MouseEvent e){
		if(p!=null && p==((PageView)e.getComponent()).getPage() && p.getSlotsCount()>0) {
			Slot sOld =p.getSlot(p.getSlotsCount()-1);
			p.removeSlot(p.getSlotsCount()-1);
			double dx = e.getPoint().getX() - pos.getX();
			double dy = e.getPoint().getY() - pos.getY();
			double angle = Math.atan2(-dy,dx);
			s=new Slot(new TriangleGeometry(pos.getX(),pos.getY(),Math.sqrt(dx*dx+dy*dy),angle));
			if(inside(e)) p.addSlot(s);
			else p.addSlot(sOld);
		}
	}
	public void mouseReleased(MouseEvent e){
		if(p!=null && p==((PageView)e.getComponent()).getPage() && p.getSlotsCount()>0) {
			Slot sOld =p.getSlot(p.getSlotsCount()-1);
			p.removeSlot(p.getSlotsCount()-1);
			double dx = e.getPoint().getX() - pos.getX();
			double dy = e.getPoint().getY() - pos.getY();
			double angle = Math.atan2(-dy,dx);
			s=new Slot(new TriangleGeometry(pos.getX(),pos.getY(),Math.sqrt(dx*dx+dy*dy),angle));
			if(inside(e)) gui.Frame.getInstance().getICommandManager().addCommand(new AddSlotCommand(p,s));
			else gui.Frame.getInstance().getICommandManager().addCommand(new AddSlotCommand(p,sOld));
		}
		p=null;
	}
	
	private boolean inside(MouseEvent e) {
		PageView pv = (PageView)e.getComponent();
		if(s.getGeometry().getMaxX()>pv.getWidth()) return false;
		if(s.getGeometry().getMinX()<0) return false;
		if(s.getGeometry().getMaxY()>pv.getHeight()) return false;
		if(s.getGeometry().getMinY()<0) return false;
		return true;
	}
}
