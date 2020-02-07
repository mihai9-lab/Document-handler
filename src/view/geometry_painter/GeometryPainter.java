package view.geometry_painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import tree.model.geometry.IGeometry;

public abstract class GeometryPainter {
	
	protected Shape shape;
	
	protected Shape scaledShape;
	
	private IGeometry iGeometry;
	
	public GeometryPainter(IGeometry iGeometry) {
		this.iGeometry=iGeometry;
	};
	
	public void paint(Graphics2D g,boolean scaled) {
		g.setColor(Color.BLACK);
		if(!scaled) {
			g.setStroke(new BasicStroke(4));
			g.draw(shape);
		}
		else {
			g.setStroke(new BasicStroke(2));
			g.draw(scaledShape);
		}
	}
	

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public boolean elementAt(Point pos){
		return getShape().contains(pos);
	}
}
