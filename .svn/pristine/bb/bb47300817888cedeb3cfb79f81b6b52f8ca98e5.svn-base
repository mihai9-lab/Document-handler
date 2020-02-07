package actions;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public  abstract class AbstractIconAction extends AbstractAction{
	public Icon loadIcon(String fileName){
		Icon icon = null;
		
		if (fileName != null) {                      
	        icon = new ImageIcon(fileName);
	    } else {                                     
	        System.err.println("Resource not found: " + fileName);
	    }

		return icon;
	}	
}