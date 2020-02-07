package node.factory;

import javax.swing.tree.TreeNode;

import tree.model.Page;

public class PageFactory extends NodeFactory {

	@Override
	public TreeNode createNode() {
		return new Page(null,null,0);
	}

}
