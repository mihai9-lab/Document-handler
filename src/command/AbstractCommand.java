package command;

import tree.model.Page;

public abstract class AbstractCommand {
	
	public void doCommand() {}
	
	public void undoCommand() {}
	
	abstract public Page getPage();
}
