package trashcan;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.tree.TreeNode;

import tree.model.Document;

public class ListDialog extends JDialog{
	
	private static ArrayList<TreeNode> node;
	private static ListDialog dialog;
	private JList<Object> list;
	
	public static ArrayList<TreeNode> showDialog(String title, String text, Object[] listChoices) {
		node = new ArrayList<TreeNode>();
		dialog = new ListDialog(title,text,listChoices);
		dialog.setVisible(true);
		
		return node;
	}
	
	private ListDialog(String title,String text,Object[] listChoices) {
		super(gui.Frame.getInstance(),title,true);
		JButton confirmButton = new JButton("Confirm");
		JButton cancelButton = new JButton("Cancel");
		
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(list.getSelectionMode() == ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) {
					Object[] nodes = list.getSelectedValues();
					for(int i=0;i<nodes.length;i++) {
						node.add((TreeNode) nodes[i]);
					}
				}
				else
					node.add((TreeNode) list.getSelectedValue());
				ListDialog.dialog.setVisible(false);
			}
			
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListDialog.dialog.setVisible(false);
			}
			
		});
		
		
		JLabel label = new JLabel(text);
		getRootPane().setDefaultButton(confirmButton);
		
		list = new JList<Object>(listChoices);
		
		if(listChoices[0] instanceof Document)
			list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		else
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(7);
		JScrollPane listScroller = new JScrollPane(list);
		
		//listScroller.setPreferredSize(new Dimension(200,500));
		listScroller.setAlignmentX(CENTER_ALIGNMENT);
		JPanel buttonPane = new JPanel();
		JPanel listPane = new JPanel();
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		buttonPane.add(confirmButton);
		buttonPane.add(cancelButton);
		listPane.setLayout(new BorderLayout());
		listPane.add(label,BorderLayout.PAGE_START);
		listPane.add(listScroller,BorderLayout.CENTER);
		listPane.add(buttonPane,BorderLayout.PAGE_END);
		
		Container contentPane  = getContentPane();
		contentPane.add(listPane,BorderLayout.CENTER);
		list.setSelectedValue(listChoices[0], true);
		pack();
		setLocationRelativeTo(gui.Frame.getInstance());
	}
}
