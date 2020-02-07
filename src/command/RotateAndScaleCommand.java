package command;

import java.util.ArrayList;

import tree.model.Page;
import tree.model.PageSelectedSlots;
import tree.model.Slot;

public class RotateAndScaleCommand extends AbstractCommand {
	
	private Page p;
	private ArrayList<Slot> slots;
	private double scaleCoef,angleDif;
	
	public RotateAndScaleCommand(Page p,PageSelectedSlots ps,double scaleCoef,double angleDif) {
		this.p=p;
		int c=ps.getSelectedCount();
		slots = new ArrayList<Slot>();
		for(int i=0;i<c;i++) slots.add(ps.getSlot(i));
		this.angleDif = angleDif;
		this.scaleCoef = scaleCoef;
	}
	
	public void doCommand() {
		ArrayList<Slot> curSlots = new ArrayList<Slot>();
		int c = p.getPageSelectedSlots().getSelectedCount();
		for(int i=0;i<c;i++) curSlots.add(p.getPageSelectedSlots().getSlot(i));
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:slots) p.getPageSelectedSlots().addSlot(s);

		p.getPageSelectedSlots().scale(scaleCoef);
		p.getPageSelectedSlots().rotate(angleDif);
		
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:curSlots) p.getPageSelectedSlots().addSlot(s);
	}
	
	public void undoCommand() {
		ArrayList<Slot> curSlots = new ArrayList<Slot>();
		int c = p.getPageSelectedSlots().getSelectedCount();
		for(int i=0;i<c;i++) curSlots.add(p.getPageSelectedSlots().getSlot(i));
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:slots) p.getPageSelectedSlots().addSlot(s);
		
		p.getPageSelectedSlots().scale(1.0/scaleCoef);
		p.getPageSelectedSlots().rotate(-angleDif);
		
		p.getPageSelectedSlots().clearSelection();
		for(Slot s:curSlots) p.getPageSelectedSlots().addSlot(s);
	}

	@Override
	public Page getPage() {
		return p;
	}
}
