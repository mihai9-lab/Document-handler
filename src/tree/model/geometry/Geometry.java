package tree.model.geometry;

import view.geometry_painter.GeometryPainter;

public abstract class Geometry implements IGeometry {
	private double xCenter;
	private double yCenter;
	private double radius;
	private double angle;
	protected transient GeometryPainter geometryPainter;
	public Geometry(double xCenter,double yCenter,double radius,double angle) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radius = radius;
		this.angle = angle;
	}
	
	
	public double getXCenter() {
		return xCenter;
	}
	
	public void setXCenter(double xCenter) {
		this.xCenter = xCenter;
	}
	
	public double getYCenter() {
		return yCenter;
	}
	
	public void setYCenter(double yCenter) {
		this.yCenter = yCenter;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public GeometryPainter getGeometryPainter() {
		return geometryPainter;
	}
	
	public void setGeometryPainter (GeometryPainter geometryPainter) {
		this.geometryPainter = geometryPainter;
	}
	
	public void rotate(double teta) {
		this.angle+=teta;
		this.refreshPainter();
	}
	
	public void scale(double c) {
		this.radius*=c;
		this.refreshPainter();
	}
	
	public void translate(double dx,double dy) {
		this.xCenter+=dx;
		this.yCenter+=dy;
		this.refreshPainter();
	}
	
	public abstract void refreshPainter();
}
