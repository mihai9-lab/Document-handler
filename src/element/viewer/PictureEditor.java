package element.viewer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.tree.TreeNode;

import directory.browser.DirectoryBrowser;
import trashcan.ListDialog;

public class PictureEditor extends JDialog{
	private static ImageIcon picture;
	private static PictureEditor dialog;
	private static JLabel picLabel;
	private static File file;
	public static ImageIcon showGUI(ImageIcon i) {
		picture = i;
		if(picture == null)
			getInitialPicture();
		if(picture == null)
			return picture;
		dialog = new PictureEditor();
		dialog.setVisible(true);
		
		return picture;
	}
	
	private static void getInitialPicture() {
		file =  new DirectoryBrowser().getImageLocation(null);
		if(file==null)
			return;
		pictureFromFile();
	}
	private static void pictureFromFile() {
		picture =  new ImageIcon((new ImageIcon(file.getAbsolutePath())).getImage());
	}
	private static void setImage() {
		ImageIcon pic = new ImageIcon(picture.getImage().getScaledInstance(picLabel.getWidth(), picLabel.getHeight(), Image.SCALE_SMOOTH));
		picLabel.setIcon(pic);
	}
	private PictureEditor() {
		super(gui.Frame.getInstance(),"Image editor",true);
		JButton chooseButton = new JButton("Choose picture");
		JButton confirmButton = new JButton("OK");
		
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PictureEditor.file = new DirectoryBrowser().getImageLocation(PictureEditor.file);
				if(PictureEditor.file==null)
					return;
				pictureFromFile();
				PictureEditor.setImage();
			}
		});
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PictureEditor.dialog.setVisible(false);
			}
		});

		picLabel = new JLabel();
		picLabel.setSize(new Dimension(1280, 720));
		setImage();
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
		buttonPane.add(chooseButton);
		buttonPane.add(confirmButton);
		
		Container contentPane =  getContentPane();
		contentPane.add(picLabel,BorderLayout.NORTH);
		contentPane.add(buttonPane,BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(gui.Frame.getInstance());
	}
}
