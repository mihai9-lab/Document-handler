package actions;

import java.awt.event.ActionEvent;

import tree.model.Page;
import tree.model.Slot;

public class TextElementAction extends AbstractIconAction{
	public TextElementAction() {
		putValue(SMALL_ICON, loadIcon("images/element-text"));
		putValue(NAME, "Text Slot");
		putValue(SHORT_DESCRIPTION, "Create Text Slot");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Page p=gui.Frame.getInstance().getProjectView().getOpenedPage();
		if(p==null)
			return;
		
		Slot s = p.getPageSelectedSlots().getEditingSlot();
		s.createElement(Slot.ElementType.TEXT);
		s.getElement().edit();
	}
}
