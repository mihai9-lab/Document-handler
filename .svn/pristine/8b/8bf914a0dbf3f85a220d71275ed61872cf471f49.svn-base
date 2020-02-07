package gui.listeners.action;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gui.CloseDialog;
import gui.Frame;
import gui.StartDialog;
import tree.model.Workspace;
import tree.model.WorkspaceModel;

public class FrameActionsListener extends WindowAdapter {
	
	@Override
	public void windowOpened(WindowEvent e) {
		StartDialog sDialog = new StartDialog();
		Workspace ws = sDialog.getWorkspace();
		WorkspaceModel workspaceModel = new WorkspaceModel(ws);
		Frame.getInstance().setWorkspaceModel(workspaceModel);
	}
	
	public void windowClosing(WindowEvent e) {
		CloseDialog cDialog = new CloseDialog();
		cDialog.open();
	}
}
