package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import observer.interfaces.IOListener;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;
import tree.model.Slot;
import view.geometry_painter.GeometryPainter;
import gui.listeners.mouse.DrawingListener;
import gui.listeners.mouse.SlotPopupListener;

public class PageView extends JPanel implements IOListener{
	
	private Page p;
	
	private DrawingListener dL;
	
	private SlotPopupListener sL;
	
	private DocumentView dV;
	
	private String name;
	
	private JLabel label;
	
	private BoxLayout boxLayout;
	
	boolean updateParent;
	
	public PageView(DocumentView dV) {
		this.setSize(420,594);
		this.setPreferredSize(getSize());
		setLayout( new GridBagLayout() );
		this.dV=dV;
		label = new JLabel();
		name="placeholder";
		label.setText(name);
		updateParent = true;
		this.add(label,new GridBagConstraints());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.white);
		dL=null;
		sL=null;
		p=null;
	}
	
	@Override
	public void update(Object o) {
		if(o instanceof Page) {
			Page p = (Page)(o);
			if(p.getErased()) {
				clear();
			}
			else {
				updateParent = false;
				clear();
				set(p);
				updateParent = true;
			}
		}
	}
	
	public void clear() {
		if(updateParent) dV.removeFromParrent(this);
		if(this.p!=null) {
			this.p.getPageSelectedSlots().removeObserver(this);
			this.p.removeObserver(this);
			this.p = null;
		}
		if(dL!=null) this.removeMouseListener(dL);
		if(dL!=null) this.removeMouseMotionListener(dL);
		if(sL!=null) this.removeMouseListener(sL);
		name = "placeholder";
		label.setText(name);
		dL=null;
		sL=null;
	}
	
	public void set(Page p) {
		if(p!=null) {
			this.p=p;
			p.addObserver(this);
			p.getPageSelectedSlots().addObserver(this);
			name=((Project)(p.getParent().getParent())).toString() + " - " + ((Document)(p.getParent())).toString() + " - " + p.toString();
			label.setText(name);
			if(updateParent) dV.addToParrent(this);
			dL=new DrawingListener();
			this.addMouseListener(dL);
			this.addMouseMotionListener(dL);
			sL=new SlotPopupListener();
			this.addMouseListener(sL);
			this.repaint();
			dV.resetDivider();
			dV.revalidate();
			dV.repaint();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Page getPage() {
		return p;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int c = p.getSlotsCount();
		for(int i=0;i<c;i++) {
			Slot s = p.getSlot(i);
			GeometryPainter gp = s.getGeometry().getGeometryPainter();
			gp.paint(g2,false);
		}
		c = p.getPageSelectedSlots().getSelectedCount();
		int t=10;
		for(int i=0;i<c;i++) {
			Slot s = p.getPageSelectedSlots().getSlot(i);
			g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
					BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
			if(p.getPageSelectedSlots().isDeletion()) g2.setPaint(Color.RED);
			else g2.setPaint(Color.BLACK);
			g2.drawRect((int)s.getGeometry().getMinX()-t, (int)s.getGeometry().getMinY()-t, (int)(s.getGeometry().getMaxX()-s.getGeometry().getMinX())+2*t, (int)(s.getGeometry().getMaxY()-s.getGeometry().getMinY())+2*t);
		}
	}
}
