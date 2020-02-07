package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import command.DragAndDropCommand;
import tree.model.Page;
import tree.model.PageSelectedSlots;
import tree.model.Slot;
import view.PageView;

public class DragAndDropState implements IState {
	
	private Point pos;
	private Page p;
	private Slot s;
	private Point begPos;
	
	public void mousePressed(MouseEvent e){
		pos=e.getPoint();
		p=((PageView)e.getComponent()).getPage();
		begPos=e.getPoint();
	}
	
	public void mouseDragged(MouseEvent e){
		if(p!=null && p==((PageView)e.getComponent()).getPage()) {
			double dx = e.getPoint().getX() - pos.getX();
			double dy = e.getPoint().getY() - pos.getY();
			p.getPageSelectedSlots().translate(dx, dy);
			if(!inside(e)) p.getPageSelectedSlots().translate(-dx, -dy);
			else pos = e.getPoint();
		}
	}
	
	public void mouseReleased(MouseEvent e){
		if(p!=null && p==((PageView)e.getComponent()).getPage()) {
			double dx = e.getPoint().getX() - pos.getX();
			double dy = e.getPoint().getY() - pos.getY();
			p.getPageSelectedSlots().translate(dx, dy);
			if(!inside(e)) p.getPageSelectedSlots().translate(-dx, -dy);
			else pos = e.getPoint();
			p.getPageSelectedSlots().translate(begPos.getX()-pos.getX(), begPos.getY()-pos.getY());
			
			gui.Frame.getInstance().getICommandManager().addCommand(new DragAndDropCommand(p,p.getPageSelectedSlots(),begPos,pos));
		}
	}
	
	private boolean inside(MouseEvent e) {
		PageView pv = (PageView)e.getComponent();
		PageSelectedSlots ps = p.getPageSelectedSlots();
		int c=ps.getSelectedCount();
		for(int i=0;i<c;i++) {
			Slot s=ps.getSlot(i);
			if(s.getGeometry().getMaxX()>pv.getWidth()) return false;
			if(s.getGeometry().getMinX()<0) return false;
			if(s.getGeometry().getMaxY()>pv.getHeight()) return false;
			if(s.getGeometry().getMinY()<0) return false;
		}
		return true;
	}
}
