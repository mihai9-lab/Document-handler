package trashcan;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import gui.Frame;
import tree.model.Document;
import tree.model.Project;
import tree.model.Workspace;

public class TrashDocuments {
	
	ArrayList<Document> deletedDocuments;
	
	public TrashDocuments() {
		deletedDocuments = new ArrayList<Document>();
	}
	
	public void addTrash(Project prj) {
		if(prj.children() == null) return;
		for(Document d: Collections.list(prj.children())) {
			if(!d.getShared())
				deletedDocuments.add(d);
		}
			
	}
	
	
	public void getDocument() {
		Workspace ws = (Workspace) Frame.getInstance().getWorkspaceTree().getModel().getRoot();
		if(deletedDocuments.isEmpty() || ws.getChildCount()==0 || deletedDocuments.isEmpty())
			return;
		
		Object[] choices = deletedDocuments.toArray();
		String question = "Choose document(s) you want to recover:";
		ArrayList<TreeNode> doc = ListDialog.showDialog("Choose document(s)",question,choices);
		if(doc == null || doc.isEmpty())
			return;
		
		choices = Collections.list(ws.children()).toArray();
		question = "Choose project you want to import document to:";
		
		ArrayList<TreeNode> prj = ListDialog.showDialog("Choose project", question, choices);
		if(prj == null || prj.isEmpty())
			return;
		Project p = (Project) prj.get(0);
		for(int i=0;i<doc.size();i++) {
			p.add(doc.get(i));
			deletedDocuments.remove(doc.get(i));
		}
		
	}
	
}
