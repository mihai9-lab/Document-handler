package command;

import java.util.ArrayList;

import tree.model.Page;
import tree.model.PageSelectedSlots;
import tree.model.Slot;

public class DeleteCommand extends AbstractCommand {
	
	private Page p;
	private ArrayList<Slot> slots;
	
	public DeleteCommand(Page p,PageSelectedSlots ps) {
		this.p=p;
		int c=ps.getSelectedCount();
		slots = new ArrayList<Slot>();
		for(int i=0;i<c;i++) slots.add(ps.getSlot(i));
	}
	
	public void doCommand() {
		for(Slot s:slots) {
			p.getPageSelectedSlots().removeSlotFromSelection(s);
			p.removeSlot(s);
		}
	}
	
	public void undoCommand() {
		for(Slot s:slots) p.addSlot(s);
	}

	@Override
	public Page getPage() {
		return p;
	}
}
