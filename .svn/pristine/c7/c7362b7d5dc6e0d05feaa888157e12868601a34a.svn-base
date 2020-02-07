package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import observer.interfaces.IOListener;
import tree.model.Page;
import tree.model.Slot;
import view.geometry_painter.GeometryPainter;
import gui.listeners.mouse.PageSelectionListener;

public class MiniPageView extends JPanel implements IOListener{
	
	private Page p;
	
	private PageSelectionListener pL;
	
	private DocumentView dV;
	
	private String name;
	
	private JLabel label;
	
	private BoxLayout boxLayout;
	
	boolean updateParent;
	
	public MiniPageView(DocumentView dV) {
		this.setSize((int)(420*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()),(int)(594*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()));
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
		pL=null;
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
			this.p.removeObserver(this);
			this.p = null;
		}
		if(pL!=null) this.removeMouseListener(pL);
		name = "placeholder";
		label.setText(name);
		pL=null;
	}
	
	public void set(Page p) {
		if(p!=null) {
			this.p=p;
			p.addObserver(this);
			name=p.toString();
			label.setText(name);
			label.setFont(new Font(null, Font.PLAIN, (int)(40*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef())));
			if(updateParent) dV.addToParrent(this);
			this.repaint();
			pL = new PageSelectionListener();
			this.addMouseListener(pL);
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
	
	public DocumentView getDocumentView() {
		return dV;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int c = p.getSlotsCount();
		for(int i=0;i<c;i++) {
			Slot s = p.getSlot(i);
			GeometryPainter gp = s.getGeometry().getGeometryPainter();
			gp.paint(g2,true);
		}
		c = p.getPageSelectedSlots().getSelectedCount();
		double t=10;
		for(int i=0;i<c;i++) {
			Slot s = p.getPageSelectedSlots().getSlot(i);
			g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
					BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
			if(p.getPageSelectedSlots().isDeletion()) g2.setPaint(Color.RED);
			else g2.setPaint(Color.BLACK);
			g2.drawRect((int)((s.getGeometry().getMinX()-t)*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()), (int)((s.getGeometry().getMinY()-t)*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()), (int)((s.getGeometry().getMaxX()-s.getGeometry().getMinX()+2*t)*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()), (int)((s.getGeometry().getMaxY()-s.getGeometry().getMinY()+2*t)*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()));
		}
	}
}
