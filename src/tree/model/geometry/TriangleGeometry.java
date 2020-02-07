package tree.model.geometry;

import view.geometry_painter.TrianglePainter;

public class TriangleGeometry extends Geometry {

	public TriangleGeometry(double xCenter, double yCenter, double radius, double angle) {
		super(xCenter, yCenter, radius, angle);
		geometryPainter = new TrianglePainter(this);
	}
	
	public void refreshPainter() {
		geometryPainter = new TrianglePainter(this);
	}
	
	private Object readResolve(){
		geometryPainter = new TrianglePainter(this);
		return this;
	}
	
	public double getMaxX() {
		double cmax = Math.max(Math.max(Math.cos(this.getAngle()), Math.cos(this.getAngle()-2*Math.PI/3)),Math.cos(this.getAngle()+2*Math.PI/3));
		return cmax*this.getRadius()+this.getXCenter();
	}
	
	public double getMaxY() {
		double smin = Math.min(Math.min(Math.sin(this.getAngle()), Math.sin(this.getAngle()-2*Math.PI/3)),Math.sin(this.getAngle()+2*Math.PI/3));
		return -smin*this.getRadius()+this.getYCenter();
	}
	
	public double getMinX() {
		double cmin = Math.min(Math.min(Math.cos(this.getAngle()), Math.cos(this.getAngle()-2*Math.PI/3)),Math.cos(this.getAngle()+2*Math.PI/3));
		return cmin*this.getRadius()+this.getXCenter();
	}
	
	public double getMinY() {
		double smax = Math.max(Math.max(Math.sin(this.getAngle()), Math.sin(this.getAngle()-2*Math.PI/3)),Math.sin(this.getAngle()+2*Math.PI/3));
		return -smax*this.getRadius()+this.getYCenter();
	}
	
	public double getSurface() {
		return 1.5*this.getRadius()*this.getRadius()*Math.sin(2.0*Math.PI/3.0);
	}
}
