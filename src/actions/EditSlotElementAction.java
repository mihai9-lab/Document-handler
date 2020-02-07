package actions;

import java.awt.event.ActionEvent;

import tree.model.Page;
import tree.model.Slot;

public class EditSlotElementAction extends AbstractIconAction {
	public EditSlotElementAction() {
		putValue(SMALL_ICON, loadIcon("images/element-edit"));
		putValue(NAME, "Edit");
		putValue(SHORT_DESCRIPTION, "Edit this slot");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Page p=gui.Frame.getInstance().getProjectView().getOpenedPage();
		if(p==null)
			return;
		
		Slot s = p.getPageSelectedSlots().getEditingSlot();
		s.getElement().edit();
	}
}
