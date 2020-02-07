package gui;

import javax.swing.JOptionPane;

import tree.model.Workspace;

public class StartDialog extends JOptionPane {

	public Workspace getWorkspace() {
		String[] options = {"Saved Workspace","Empty Workspace"};
		int option = showDialog(options);
		
		if(option == 0) {
			Workspace ws=Frame.getInstance().getSerialiser().openWorkspace();
			if(ws!=null)
				return ws;
		}
		
		return new Workspace();
		
	}

	private int showDialog(String[] options) {
		return StartDialog.showOptionDialog(gui.Frame.getInstance(),
												   "Which workspace would you like to open?",
												   "Message",
												   JOptionPane.DEFAULT_OPTION,
												   JOptionPane.INFORMATION_MESSAGE,
												   null,
												   options,
												   options[0]);
	}
}
