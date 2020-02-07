package directory.browser;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import directory.browser.file.filters.AbstractFileFilter;
import directory.browser.file.filters.DocumentFileFilter;
import directory.browser.file.filters.GerudokFileFilter;
import directory.browser.file.filters.ProjectFileFilter;
import directory.browser.file.filters.WorkspaceFileFilter;
import gui.Frame;
import tree.model.ITreeNodeSerialization;
import tree.model.Project;
import tree.model.Workspace;

public class DirectoryBrowser extends JFileChooser implements IDirectoryBrowser{
	
	public DirectoryBrowser() {
		super();
	}
	
	public File getSaveLocation(ITreeNodeSerialization node) {
		
		this.setAcceptAllFileFilterUsed(false);
		this.setFileFilter(returnFileFilter(node));
		
		String extension = ((AbstractFileFilter)this.getFileFilter()).getExtension();
		this.setSelectedFile(new File(node.toString() + extension));
		
		int actionValue=this.showSaveDialog(Frame.getInstance());
		if(actionValue==JFileChooser.CANCEL_OPTION || actionValue==JFileChooser.ERROR_OPTION)
			return null;
		
		File f = this.getSelectedFile();
		f=extensionCheck(f, extension);
		f=nameCheck(f,extension);

			
		return f;
	}
	
	public File getOpenLocation() {
		this.setAcceptAllFileFilterUsed(false);
		this.setFileFilter(new GerudokFileFilter());
		
		int actionValue = this.showOpenDialog(Frame.getInstance());
		if(actionValue==JFileChooser.CANCEL_OPTION || actionValue==JFileChooser.ERROR_OPTION)
			return null;
		
		File f = this.getSelectedFile();
		
		return f;
	}

	public File getWorkspaceLocation() {
		this.setAcceptAllFileFilterUsed(false);
		this.setFileFilter(new WorkspaceFileFilter());
		
		int actionValue = this.showOpenDialog(Frame.getInstance());
		if(actionValue==JFileChooser.CANCEL_OPTION || actionValue==JFileChooser.ERROR_OPTION)
			return null;
		
		File f = this.getSelectedFile();
		
		return f;
	}
	
	public File getImageLocation(File currentLocation) {
		this.setAcceptAllFileFilterUsed(false);
		this.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
		this.setCurrentDirectory(currentLocation);
		int actionValue = this.showOpenDialog(Frame.getInstance());
		if(actionValue==JFileChooser.CANCEL_OPTION || actionValue==JFileChooser.ERROR_OPTION)
			return null;
		
		File f = this.getSelectedFile();
		
		return f;
	}
	
	private static FileFilter returnFileFilter(ITreeNodeSerialization node) {
		if(node instanceof Workspace)
			return new WorkspaceFileFilter();
		else if(node instanceof Project)
			return new ProjectFileFilter();
		else
			return new DocumentFileFilter();
	}
	
	private static File extensionCheck(File f, String extension) {
		if(f.getName().endsWith(extension))
			return f;
		return new File(f.toString() + extension);
	}
	
	private static File nameCheck(File f, String extension) {
		while(f.isFile()) {
			String[] options = {"Input new file name","Overwrite file","Cancel"};
			int option = JOptionPane.showOptionDialog(gui.Frame.getInstance(),
													   "A file with this name already exists in this directory.\n Would you like to:",
													   "Warning",
													   JOptionPane.DEFAULT_OPTION,
													   JOptionPane.WARNING_MESSAGE,
													   null,
													   options,
													   options[0]);
			if(option == 2)
				return null;
			if(option == 1)
				break;
			
			String name = JOptionPane.showInputDialog(Frame.getInstance(), "Choose new name:", f.getName());
			
			if(name==null)
				return null;
			f = new File(f.getParent() + "\\" + name);
			f=extensionCheck(f, extension);
		}
		return f;
	}


}
