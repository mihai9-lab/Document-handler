package gui.listeners.change;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tree.model.Document;
import view.DocumentView;

public class DocumentViewsSelectionListener implements ChangeListener {
    
	public void stateChanged(ChangeEvent e) {
        JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
        int n = tabbedPane.getComponentCount();
        if(n==0) return;
        int selectedIndex = tabbedPane.getSelectedIndex();
    	Document d = ((DocumentView)tabbedPane.getComponentAt(selectedIndex)).getDocument();
    	if(!d.isSelected()) d.select();
    }
}