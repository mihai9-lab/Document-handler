package command.manager;

import java.util.ArrayList;

import command.AbstractCommand;
import sharing.mediator.MediatorUpdates;
import tree.model.Document;
import tree.model.Page;

public class CommandManager implements ICommandManager {
	
		private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();
		private int currentCommand = 0;
		
		public void addCommand(AbstractCommand command){
			while(currentCommand < commands.size())
				commands.remove(currentCommand);
			commands.add(command);
			doCommand();
		}
		
		public void doCommand(){
			if(currentCommand < commands.size()){
				commands.get(currentCommand++).doCommand();
				gui.Frame.getInstance().getActionManager().getUndoAction().setEnabled(true);
				Page pg =commands.get(currentCommand-1).getPage();
				((Document)pg.getParent()).updateMediator(MediatorUpdates.PAGE_COMMAND, pg);
			}
			if(currentCommand==commands.size()){
				gui.Frame.getInstance().getActionManager().getRedoAction().setEnabled(false);
			}
		}

		public void undoCommand(){
			if(currentCommand > 0){
				gui.Frame.getInstance().getActionManager().getRedoAction().setEnabled(true);
				commands.get(--currentCommand).undoCommand();
				Page pg =commands.get(currentCommand).getPage();
				((Document)pg.getParent()).updateMediator(MediatorUpdates.PAGE_COMMAND, pg);
			}
			if(currentCommand==0){
				gui.Frame.getInstance().getActionManager().getUndoAction().setEnabled(false);
			}
		}
}
