package gui;

import java.awt.Color;

import javax.swing.JToolBar;

public class PaletteBar extends JToolBar {
	
	public PaletteBar() {
		initialise();
	}
	
	public void initialise() {
		
		
		this.add(gui.Frame.getInstance().getActionManager().getDrawRectangleAction());
		this.add(gui.Frame.getInstance().getActionManager().getDrawCircleAction());
		this.add(gui.Frame.getInstance().getActionManager().getDrawTriangleAction());
		
		this.add(new Separator());
		

		this.add(gui.Frame.getInstance().getActionManager().getSelectShapeAction());
		this.add(new Separator());
		
		this.add(gui.Frame.getInstance().getActionManager().getRotateAndScaleAction());
		this.add(gui.Frame.getInstance().getActionManager().getDragAndDropAction());
		this.add(gui.Frame.getInstance().getActionManager().getDeleteSlotAction());
		
		this.add(new Separator());
		
		this.add(gui.Frame.getInstance().getActionManager().getTrashcanAction());
		setFloatable(true);
		setBackground(Color.WHITE);
		

		this.setOrientation(VERTICAL);
	}
}
