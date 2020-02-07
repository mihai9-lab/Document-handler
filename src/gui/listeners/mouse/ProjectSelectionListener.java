package gui.listeners.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import gui.Frame;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;

public class ProjectSelectionListener implements MouseListener{

	public void mouseClicked(MouseEvent arg0) {

		if (arg0.getClickCount() == 2) {
			Object node = Frame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

			if(node != null) {
				if(node instanceof Project) {

					Project prj =  (Project)node;

					prj.select();
				}
				else if(node instanceof Document) {
					
					Document doc = (Document)node;
					
					doc.select();
				}
				else if(node instanceof Page) {
					
					Page pag = (Page)node;
					
					pag.select();
				}
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
