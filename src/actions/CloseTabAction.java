package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import tree.model.Document;
import view.DocumentView;

public class CloseTabAction extends AbstractIconAction {
	public CloseTabAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-close.png"));
		putValue(NAME, "Close Tab");
		putValue(SHORT_DESCRIPTION, "Close Tab (Ctrl + E)");
	}

	public void actionPerformed(ActionEvent arg0) {
		DocumentView dV = (DocumentView)gui.Frame.getInstance().getProjectView().getDocumentViews().getSelectedComponent();
		if(dV!=null) {
			Document d = dV.getDocument();
			if(!d.isClosed()) d.setClosed(true);
		}
		else {
			gui.Frame.getInstance().getExceptionHandler().handleException("no_tabs");
		}
	}
}
