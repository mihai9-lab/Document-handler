package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class ToolBarAppearanceActionListener  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JCheckBox jcb = (JCheckBox)(arg0.getSource());
		if(jcb.getText()=="Open") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getOpenNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Save") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getSaveNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Save As") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getSaveAsNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Rename") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getRenameNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="New") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getNewNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Delete") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getDeleteNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Close Tab") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getCloseTabAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Close All Tabs") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getCloseAllTabsAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Delete") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getDeleteNodeAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Copy") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getCopyAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Paste") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getPasteAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Cut") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getCutAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Undo") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getUndoAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Redo") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getRedoAction(),jcb.isSelected());
		}
		else if(jcb.getText()=="Share") {
			gui.Frame.getInstance().getIConfigurations().setActionInToolbar(gui.Frame.getInstance().getActionManager().getShareAction(),jcb.isSelected());
		}
	}
}
