package tree.model.geometry;

import view.geometry_painter.RectanglePainter;

public class RectangleGeometry extends Geometry {

	private double angle2;
	
	public RectangleGeometry(double xCenter, double yCenter, double radius, double angle,double angle2) {
		super(xCenter, yCenter, radius, angle);
		this.angle2 = angle2;
		geometryPainter = new RectanglePainter(this);
	}
	
	public double getAngle2() {
		return angle2;
	}
	
	public void setAngle2(double angle2) {
		this.angle2 = angle2;
	}
	
	public void rotate(double teta) {
		this.setAngle(this.getAngle()+teta);
		this.angle2 += teta;
		refreshPainter();
	}
	
	public void refreshPainter() {
		geometryPainter = new RectanglePainter(this);
	}
	
	private Object readResolve(){
		geometryPainter = new RectanglePainter(this);
		return this;
	}
	
	public double getMaxX() {
		double cmax = Math.max(Math.max(Math.cos(this.getAngle()), Math.cos(this.getAngle2())), Math.max(Math.cos(this.getAngle()+Math.PI), Math.cos(this.getAngle2()+Math.PI)));
		return cmax*this.getRadius()+this.getXCenter();
	}
	
	public double getMaxY() {
		double smin = Math.min(Math.min(Math.sin(this.getAngle()), Math.sin(this.getAngle2())), Math.min(Math.sin(this.getAngle()+Math.PI), Math.sin(this.getAngle2()+Math.PI)));
		return -smin*this.getRadius()+this.getYCenter();
	}
	
	public double getMinX() {
		double cmin = Math.min(Math.min(Math.cos(this.getAngle()), Math.cos(this.getAngle2())), Math.min(Math.cos(this.getAngle()+Math.PI), Math.cos(this.getAngle2()+Math.PI)));
		return cmin*this.getRadius()+this.getXCenter();
	}
	
	public double getMinY() {
		double smax = Math.max(Math.max(Math.sin(this.getAngle()), Math.sin(this.getAngle2())), Math.max(Math.sin(this.getAngle()+Math.PI), Math.sin(this.getAngle2()+Math.PI)));
		return -smax*this.getRadius()+this.getYCenter();
	}
	
	public double getSurface() {
		double angleDif = this.getAngle()-this.getAngle2();
		return this.getRadius()*this.getRadius()*(Math.abs(Math.sin(angleDif))+Math.abs(Math.sin(Math.PI-angleDif)));
	}
}
