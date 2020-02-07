package element.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLEditorKit;

import directory.browser.DirectoryBrowser;

public class TextEditor extends JDialog {
	private static DefaultStyledDocument document;
	private static TextEditor dialog;
	private static JTextPane textPane;
	public static DefaultStyledDocument showGUI(DefaultStyledDocument d) {
		document = d;
		dialog = new TextEditor();
		dialog.setVisible(true);
		return d;
	}
	
	private TextEditor() {
		super(gui.Frame.getInstance(),"Text editor",true);
		JButton closeButton = new JButton("Close");

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextEditor.dialog.setVisible(false);
			}
		});
		
		JTextPane textPane = new JTextPane(document);
		textPane.setCaretPosition(0);
		JScrollPane scrollPane =  new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		JToolBar tb = getToolBar();
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
		buttonPane.add(closeButton);
		
		Container contentPane = getContentPane();
		contentPane.add(tb,BorderLayout.NORTH);
		contentPane.add(scrollPane,BorderLayout.CENTER);
		contentPane.add(buttonPane,BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(gui.Frame.getInstance());
	}
	
	private JToolBar getToolBar() {
		JToolBar toolBar = new JToolBar();
		Action bold = new StyledEditorKit.BoldAction();
		bold.putValue(Action.NAME, "Bold");
		bold.putValue(Action.SMALL_ICON,new ImageIcon("editor_images/editor-bold.png"));
		Action italic = new StyledEditorKit.ItalicAction();
		italic.putValue(Action.NAME, "Italic");
		italic.putValue(Action.SMALL_ICON,new ImageIcon("editor_images/editor-italic.png"));
		Action underline = new StyledEditorKit.UnderlineAction();
		underline.putValue(Action.NAME, "Underline");
		underline.putValue(Action.SMALL_ICON,new ImageIcon("editor_images/editor-underline.png"));
		toolBar.add(bold);
		toolBar.add(italic);
		toolBar.add(underline);
		toolBar.add(getFontSizeBox());
		toolBar.add(getFontFamilyBox());
		toolBar.add(getColorPicker());
		return toolBar;
	}
	
	private JComboBox<String> getFontSizeBox() {
		
		String[] fontSize = new String[30];
		Integer size=10;
		
		for(int i=0;i<30;i++){
			fontSize[i] = size.toString();
			size+=2;
		}
		
		JComboBox<String> box= new JComboBox<String>(fontSize);
		
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String size = (String) box.getSelectedItem();
				Action a =  new StyledEditorKit.FontSizeAction(size, Integer.parseInt(size));
				a.actionPerformed(e);
			}
		});
		return box;
	}
	
	private JComboBox<String> getFontFamilyBox() {

		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = e.getAvailableFontFamilyNames();
		JComboBox<String> box= new JComboBox<String>(fonts);
		
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String font = (String) box.getSelectedItem();
				Action a = new StyledEditorKit.FontFamilyAction(font,
		                font);
				a.actionPerformed(e);
			}
		});
		return box;
	}
	
	private JButton getColorPicker() {
		JButton b = new JButton("Color");
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = ColorPicker.showColorPicker();
				Action a = new StyledEditorKit.ForegroundAction(c.toString(),c);
				a.actionPerformed(e);
			}
		});
		return b;
	}

	
	
	
}

	