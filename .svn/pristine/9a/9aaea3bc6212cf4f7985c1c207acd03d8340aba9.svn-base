package gui;

import javax.swing.JComponent;
import javax.swing.JSplitPane;

public class SplitPane extends JSplitPane {
	private JComponent leftPane;
	private JComponent rightPane;
	private int width;
	public SplitPane(int width,JComponent leftPane,JComponent rightPane) {
		super(JSplitPane.HORIZONTAL_SPLIT,leftPane,rightPane);
		this.width=width;
		this.leftPane=leftPane;
		this.rightPane=rightPane;
		this.setOneTouchExpandable(true);
		this.setDividerLocation(width);
	}
}
