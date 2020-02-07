package command;

import java.awt.Point;
import java.util.ArrayList;

import tree.model.Page;
import tree.model.PageSelectedSlots;
import tree.model.Slot;

public class DragAndDropCommand extends AbstractCommand {
	
	private Page p;
	private ArrayList<Slot> slots;
	private Point begPos;
	private Point pos;
	
	public DragAndDropCommand(Page p,PageSelectedSlots ps,Point begPos,Point pos) {
		this.p=p;
		int c=ps.getSelectedCount();
		slots = new ArrayList<Slot>();
		for(int i=0;i<c;i++) slots.add(ps.getSlot(i));
		this.begPos = begPos;
		this.pos = pos;
	}
	
	public void doCommand() {
		ArrayList<Slot> curSlots = new ArrayList<Slot>();
		int c = p.getPageSelectedSlots().getSelectedCount();
		for(int i=0;i<c;i++) curSlots.add(p.getPageSelectedSlots().getSlot(i));
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:slots) p.getPageSelectedSlots().addSlot(s);
		
		p.getPageSelectedSlots().translate(pos.getX()-begPos.getX(), pos.getY()-begPos.getY());
		
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:curSlots) p.getPageSelectedSlots().addSlot(s);
	}
	
	public void undoCommand() {
		ArrayList<Slot> curSlots = new ArrayList<Slot>();
		int c = p.getPageSelectedSlots().getSelectedCount();
		for(int i=0;i<c;i++) curSlots.add(p.getPageSelectedSlots().getSlot(i));
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:slots) p.getPageSelectedSlots().addSlot(s);
		
		p.getPageSelectedSlots().translate(begPos.getX()-pos.getX(), begPos.getY()-pos.getY());
		
		
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:curSlots) p.getPageSelectedSlots().addSlot(s);
	}

	@Override
	public Page getPage() {
		return p;
	}
}
