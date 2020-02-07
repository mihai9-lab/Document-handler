package error_handling;

public class ExceptionFactory {
	public ExceptionFactory() {
		
	}
	public static Exception createException(String s) {
		if(s=="no_project") return new Exception("No project is selected!");
		else if(s=="no_tabs") return new Exception("No tabs are open!");
		else if(s=="workspace_deleted") return new Exception("You can't delete workspace!");
		else if(s=="no_node_selected") return new Exception("You have to select a node!");
		else if(s=="page_child") return new Exception("You can't add child to a page!");
		else if(s=="workspace_rename") return new Exception("You can't rename workspace!");
		else if(s=="invalid_minipage_size") return new Exception("You have selected invalid aspect ratio of Minipage!");
		else if(s=="page_saved") return new Exception("You can't save a page. You can only save Workspace, Project or a Document!");
		else if(s=="invalid_file") return new Exception("You didn't select valid file!");
		else return new Exception("An unkown error occurred!");
	}
}
