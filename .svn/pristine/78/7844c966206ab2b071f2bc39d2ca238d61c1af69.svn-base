package gui;

import javax.swing.JOptionPane;

import tree.model.Workspace;

public class CloseDialog extends JOptionPane {

	
	public void open() {
		
		Workspace ws = (Workspace) Frame.getInstance().getWorkspaceTree().getModel().getRoot();
		
		if(ws.isChanged()) 
			saveAndExit(ws);
		else
			justExit();
		
	}
	
	
	private void saveAndExit(Workspace ws) {
		String message = "You haven't saved Workspace. If you exit without saving everything since last save will be lost.";
		String[] options = {"Save and Exit","Exit without Saving","Cancel"};
		
		int option = showDialog(message,options);
		
		if(option==0) {
			if(Frame.getInstance().getSerialiser().save(ws))
				System.exit(0);
			else
				saveAndExit(ws);	
		}
		if(option==1)
			System.exit(0);
	}
	
	private void justExit() {
		String message = "Are you sure you want to exit?";
		String[] options = {"Exit","Cancel"};
		
		int option = showDialog(message,options);
		
		if(option == 0)
			System.exit(0);
	}
	
	private int showDialog(String message,String[] options) {
		return CloseDialog.showOptionDialog(gui.Frame.getInstance(),
												   message,
												   "Message",
												   JOptionPane.DEFAULT_OPTION,
												   JOptionPane.INFORMATION_MESSAGE,
												   null,
												   options,
												   options[0]);
	}
}
