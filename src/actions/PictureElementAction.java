package actions;

import java.awt.event.ActionEvent;

import tree.model.Page;
import tree.model.Slot;

public class PictureElementAction extends AbstractIconAction{

	public PictureElementAction() {
		putValue(SMALL_ICON, loadIcon("images/element-picture"));
		putValue(NAME, "Picture Slot");
		putValue(SHORT_DESCRIPTION, "Create Picture Slot");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Page p=gui.Frame.getInstance().getProjectView().getOpenedPage();
		if(p==null)
			return;
		
		Slot s = p.getPageSelectedSlots().getEditingSlot();
		s.createElement(Slot.ElementType.PICTURE);
		s.getElement().edit();
	}
}
