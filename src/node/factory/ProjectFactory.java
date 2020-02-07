package node.factory;

import javax.swing.tree.TreeNode;

import tree.model.Project;

public class ProjectFactory extends NodeFactory {

	@Override
	public TreeNode createNode() {
		return new Project(null,null,0);
	}

}
