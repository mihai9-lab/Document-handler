package tree.model.geometry;

import view.geometry_painter.CirclePainter;

public class CircleGeometry extends Geometry {

	public CircleGeometry(double xCenter, double yCenter, double radius, double angle) {
		super(xCenter, yCenter, radius, angle);
		geometryPainter = new CirclePainter(this);
	}
	
	public void refreshPainter() {
		geometryPainter = new CirclePainter(this);
	}
	
	private Object readResolve(){
		geometryPainter = new CirclePainter(this);
		return this;
	}
	
	public double getMaxX() {
		return this.getRadius()+this.getXCenter();
	}
	
	public double getMaxY() {
		return this.getRadius()+this.getYCenter();
	}
	
	public double getMinX() {
		return -this.getRadius()+this.getXCenter();
	}
	
	public double getMinY() {
		return -this.getRadius()+this.getYCenter();
	}
	
	public double getSurface() {
		return this.getRadius()*this.getRadius()*Math.PI;
	}
}
