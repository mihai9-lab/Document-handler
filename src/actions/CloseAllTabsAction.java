package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import tree.model.Project;
import view.ProjectView;

public class CloseAllTabsAction extends AbstractIconAction {
	public CloseAllTabsAction() {
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(
		        KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("images/toolbar-close-all.png"));
		putValue(NAME, "Close All Tabs");
		putValue(SHORT_DESCRIPTION, "Close All Tabs (Ctrl + T)");
	}

	public void actionPerformed(ActionEvent arg0) {
		ProjectView pV = (ProjectView)gui.Frame.getInstance().getProjectView();
		if(pV!=null) {
			Project p = pV.getProject();
			p.closeAll();
		}
		else {
			gui.Frame.getInstance().getExceptionHandler().handleException("no_project");
		}
	}
}
