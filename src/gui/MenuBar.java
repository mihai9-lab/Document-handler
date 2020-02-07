package gui;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JToolBar.Separator;

import gui.listeners.action.MinipageSizeActionListener;
import gui.listeners.action.ToolBarAppearanceActionListener;


public class MenuBar extends JMenuBar{
	private JMenu menuFile;
	private JMenu menuWindow;
	private JMenu menuToolbarAppearance;
	private JMenu menuHelp;
	private JMenu menuConfigureMinipageSize;
	private ToolBarAppearanceActionListener t;
	
	public MenuBar () {
		initialise();
	}
	
	private void initialise() {
		menuFile = new JMenu("File");
	    menuWindow = new JMenu("Window");
	    menuConfigureMinipageSize = new JMenu("Configure Minipage Size");
	    menuToolbarAppearance = new JMenu("Toolbar Appearance");
	    menuHelp = new JMenu("Help");
	    
	    t = new ToolBarAppearanceActionListener();
	    
	    menuFile.add(gui.Frame.getInstance().getActionManager().getNewNodeAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getRenameNodeAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getDeleteNodeAction());
	    menuFile.add(new Separator());
	    
	    menuFile.add(gui.Frame.getInstance().getActionManager().getCutAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getCopyAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getPasteAction());
	    menuFile.add(new Separator());
	    
	    menuFile.add(gui.Frame.getInstance().getActionManager().getOpenNodeAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getSaveNodeAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getSaveAsNodeAction());
	    menuFile.add(new Separator());
	    
	    menuFile.add(gui.Frame.getInstance().getActionManager().getCloseTabAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getCloseAllTabsAction());
	    menuFile.add(new Separator());
	    
	    menuFile.add(gui.Frame.getInstance().getActionManager().getUndoAction());
	    menuFile.add(gui.Frame.getInstance().getActionManager().getRedoAction());
	    
	    menuHelp.add(gui.Frame.getInstance().getActionManager().getAboutDialogAction());
	    
	    
	    
	    JCheckBox openNodeBox = new JCheckBox("Open");
	    openNodeBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getOpenNodeAction()));
	    openNodeBox.addActionListener(t);
	    
	    JCheckBox saveNodeBox = new JCheckBox("Save");
	    saveNodeBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getSaveNodeAction()));
	    saveNodeBox.addActionListener(t);
	    
	    JCheckBox saveAsNodeBox = new JCheckBox("Save As");
	    saveAsNodeBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getSaveAsNodeAction()));
	    saveAsNodeBox.addActionListener(t);
	    
	    JCheckBox newNodeBox = new JCheckBox("New");
	    newNodeBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getNewNodeAction()));
	    newNodeBox.addActionListener(t);
	    
	    JCheckBox renameNodeBox = new JCheckBox("Rename");
	    renameNodeBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getRenameNodeAction()));
	    renameNodeBox.addActionListener(t);
	    
	    JCheckBox deleteNodeBox = new JCheckBox("Delete");
	    deleteNodeBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getDeleteNodeAction()));
	    deleteNodeBox.addActionListener(t);
	    
	    JCheckBox closeTabBox = new JCheckBox("Close Tab");
	    closeTabBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCloseTabAction()));
	    closeTabBox.addActionListener(t);
	    
	    JCheckBox closeAllTabsBox = new JCheckBox("Close All Tabs");
	    closeAllTabsBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCloseAllTabsAction()));
	    closeAllTabsBox.addActionListener(t);
	    
	    JCheckBox undoBox = new JCheckBox("Undo");
	    undoBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getUndoAction()));
	    undoBox.addActionListener(t);
	    
	    JCheckBox redoBox = new JCheckBox("Redo");
	    redoBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getRedoAction()));
	    redoBox.addActionListener(t);
	    
	    JCheckBox copyBox = new JCheckBox("Copy");
	    copyBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCopyAction()));
	    copyBox.addActionListener(t);
	    
	    JCheckBox pasteBox = new JCheckBox("Paste");
	    pasteBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getPasteAction()));
	    pasteBox.addActionListener(t);
	    
	    JCheckBox cutBox = new JCheckBox("Cut");
	    cutBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getCutAction()));
	    cutBox.addActionListener(t);
	    
	    JCheckBox shareBox = new JCheckBox("Share");
	    shareBox.setSelected(gui.Frame.getInstance().getIConfigurations().isActionInToolbar(gui.Frame.getInstance().getActionManager().getShareAction()));
	    shareBox.addActionListener(t);
	    
	    JTextField MinipageSizeComparedToPageSize = new JTextField("Minipage size");
	    MinipageSizeComparedToPageSize.setText("0.2");
	    MinipageSizeComparedToPageSize.addActionListener(new MinipageSizeActionListener());
	    
	    menuToolbarAppearance.add(openNodeBox);
	    
	    menuToolbarAppearance.add(saveNodeBox);
	    
	    menuToolbarAppearance.add(saveAsNodeBox);
	    
	    menuToolbarAppearance.add(newNodeBox);
	    
	    menuToolbarAppearance.add(deleteNodeBox);
	    
	    menuToolbarAppearance.add(renameNodeBox);
	    
	    menuToolbarAppearance.add(closeTabBox);
	    
	    menuToolbarAppearance.add(closeAllTabsBox);

	    menuToolbarAppearance.add(copyBox);
	    
	    menuToolbarAppearance.add(pasteBox);
	    
	    menuToolbarAppearance.add(cutBox);
	    
	    menuToolbarAppearance.add(shareBox);
	    
	    menuToolbarAppearance.add(undoBox);
	    
	    menuToolbarAppearance.add(redoBox);
	    
	    menuWindow.add(menuToolbarAppearance);
	    
	    menuConfigureMinipageSize.add(MinipageSizeComparedToPageSize);
	    
	    menuWindow.add(menuConfigureMinipageSize);
	    
	    add(menuFile);
	    add(menuWindow);
	    add(menuHelp);
	}
}
