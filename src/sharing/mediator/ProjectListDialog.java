package sharing.mediator;

import java.util.Collections;

import javax.swing.JOptionPane;

import gui.Frame;
import tree.model.Project;
import tree.model.Workspace;

public class ProjectListDialog extends JOptionPane{
	
	public Project open() {
		
		Workspace ws = (Workspace) Frame.getInstance().getWorkspaceTree().getModel().getRoot();
		  
		Object[] projects = Collections.list(ws.children()).toArray();
		Project input = (Project) showInputDialog(null, 
												"What project do you want to share this document with",
												"ShareBox", 
												JOptionPane.QUESTION_MESSAGE, 
												null,
												projects,
												projects[0]);
		return input;
		
	}

}
