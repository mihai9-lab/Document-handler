package tree.model.geometry;

import java.io.Serializable;

import view.geometry_painter.GeometryPainter;

public interface IGeometry extends Serializable{
	
	public GeometryPainter getGeometryPainter() ;
	
	public void setGeometryPainter (GeometryPainter geometryPainter) ;
	
	public double getXCenter() ;
	
	public void setXCenter(double xCenter) ;
	
	public double getYCenter() ;
	
	public void setYCenter(double yCenter) ;
	
	public double getRadius() ;
	
	public void setRadius(double radius) ;
	
	public void rotate(double teta);
	
	public void scale(double c);
	
	public void translate(double dx,double dy);
	
	public double getMaxX() ;
	
	public double getMinX() ;
	
	public double getMaxY() ;
	
	public double getMinY() ;
	
	public double getSurface() ;
	
	public void refreshPainter();
}
