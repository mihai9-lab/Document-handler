package tree.view;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import tree.model.Workspace;
import tree.model.Project;
import tree.model.Document;
import tree.model.Page;


public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer{

	public WorkspaceTreeCellRendered() {
		
	}

	  public Component getTreeCellRendererComponent(
              JTree tree,
              Object value,
              boolean sel,
              boolean expanded,
              boolean leaf,
              int row,
              boolean hasFocus) {
              super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
                  
             
              if (value instanceof Workspace ) {
            	  Icon icon = new ImageIcon("images/workspace-icon.png");
            	  setIcon(icon);
              }
              else if (value instanceof Project ) {
            	  Icon icon = new ImageIcon("images/project-icon.png");
            	  setIcon(icon);
              }
              else if (value instanceof Document ) {
            	  Icon icon = new ImageIcon("images/document-icon.png");
            	  setIcon(icon);
              }
              else if (value instanceof Page ) {
            	  Icon icon = new ImageIcon("images/page-icon.png");
            	  setIcon(icon);
              }
              return this;
	  }
}  