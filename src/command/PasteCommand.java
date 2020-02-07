package command;

import java.util.ArrayList;

import tree.model.Page;
import tree.model.Slot;

public class PasteCommand extends AbstractCommand{
	private Page p;
	private ArrayList<Slot> slots;
	
	public PasteCommand(Page p,ArrayList<Slot> slots) {
		this.p=p;
		this.slots=slots;
	}
	
	public void doCommand() {
		p.getPageSelectedSlots().clearSelection();
		for(Slot s: slots) {
			p.addSlot(s);
			p.getPageSelectedSlots().addSlot(s);
			gui.Frame.getInstance().getIStateManager().setDragAndDropState();
		}
	}
	
	public void undoCommand() {
		for(Slot s: slots) {
			p.removeSlot(s);
			p.getPageSelectedSlots().removeSlotFromSelection(s);
		}
	}
	@Override
	public Page getPage() {
		return p;
	}

}
