package element.viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.tree.TreeNode;

import trashcan.ListDialog;

public class ColorPicker extends JDialog{
	private static Color c;
	private static JColorChooser colorChooser;
	private static ColorPicker dialog;
	public static Color showColorPicker() {
		c=null;
		dialog=new ColorPicker();
		dialog.setVisible(true);
		return  c;
	}
	
	private ColorPicker() {
		super(gui.Frame.getInstance(),"Choose Color",true);
		JButton confirmButton = new JButton("Confirm");
		
		confirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ColorPicker.c=colorChooser.getColor();
				ColorPicker.dialog.setVisible(false);
			}
		});
		
		colorChooser = new JColorChooser();
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPane.add(confirmButton);
		
		Container contentPane  = getContentPane();
		contentPane.add(colorChooser,BorderLayout.CENTER);
		contentPane.add(buttonPane,BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(gui.Frame.getInstance());
	}
}
