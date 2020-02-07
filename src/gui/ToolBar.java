package gui;

import java.awt.Color;

import javax.swing.JToolBar;

import observer.interfaces.IOListener;

public class ToolBar extends JToolBar implements IOListener {

	public ToolBar() {
		initialise();
	}
	
	public void initialise() {
		
		this.add(gui.Frame.getInstance().getActionManager().getNewNodeAction());
		this.add(gui.Frame.getInstance().getActionManager().getRenameNodeAction());
		this.add(gui.Frame.getInstance().getActionManager().getDeleteNodeAction());
		this.add(new Separator());
		
		this.add(gui.Frame.getInstance().getActionManager().getCutAction());
		this.add(gui.Frame.getInstance().getActionManager().getCopyAction());
		this.add(gui.Frame.getInstance().getActionManager().getPasteAction());
		this.add(gui.Frame.getInstance().getActionManager().getShareAction());
		this.add(new Separator());
		
		this.add(gui.Frame.getInstance().getActionManager().getOpenNodeAction());
		this.add(gui.Frame.getInstance().getActionManager().getSaveNodeAction());
		this.add(gui.Frame.getInstance().getActionManager().getSaveAsNodeAction());
		this.add(new Separator());
		
		this.add(gui.Frame.getInstance().getActionManager().getCloseTabAction());
		this.add(gui.Frame.getInstance().getActionManager().getCloseAllTabsAction());
		this.add(new Separator());
		
		this.add(gui.Frame.getInstance().getActionManager().getUndoAction());
		this.add(gui.Frame.getInstance().getActionManager().getRedoAction());
		
		
		setFloatable(true);
		setBackground(new Color(0xDFDDC7));
		
		resetActions();
	}
	
	public void update(Object event) {
		this.resetActions();
	}
	
	private void resetActions() {
		this.removeAll();
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getNewNodeAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getNewNodeAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getRenameNodeAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getRenameNodeAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getDeleteNodeAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getDeleteNodeAction());
		}
		this.add(new Separator());
		
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCutAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getCutAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCopyAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getCopyAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getPasteAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getPasteAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getShareAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getShareAction());
		}
		this.add(new Separator());
		
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getSaveNodeAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getSaveNodeAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getSaveAsNodeAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getSaveAsNodeAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getOpenNodeAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getOpenNodeAction());
		}
		this.add(new Separator());
		
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCloseTabAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getCloseTabAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCloseAllTabsAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getCloseAllTabsAction());
		}
		
		this.add(new Separator());
		
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getUndoAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getUndoAction());
		}
		if(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getRedoAction())) {
			this.add(gui.Frame.getInstance().getActionManager().getRedoAction());
		}
		
		this.updateUI();
		setFloatable(true);
		setBackground(new Color(0xDFDDC7));
		
	}
}
