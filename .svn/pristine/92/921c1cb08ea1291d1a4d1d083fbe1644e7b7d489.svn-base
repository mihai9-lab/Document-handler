package view.geometry_painter;

import java.awt.geom.GeneralPath;

import tree.model.geometry.RectangleGeometry;

public class RectanglePainter extends GeometryPainter{
	public RectanglePainter(RectangleGeometry r) {
		
		super(r);
		
		shape=new GeneralPath();
		
		((GeneralPath)shape).moveTo(r.getXCenter()+r.getRadius()*Math.cos(r.getAngle()),r.getYCenter()-r.getRadius()*Math.sin(r.getAngle()));
		
		((GeneralPath)shape).lineTo(r.getXCenter()+r.getRadius()*Math.cos(r.getAngle2()),r.getYCenter()-r.getRadius()*Math.sin(r.getAngle2()));
		
		((GeneralPath)shape).lineTo(r.getXCenter()+r.getRadius()*Math.cos(r.getAngle()+Math.PI),r.getYCenter()-r.getRadius()*Math.sin(r.getAngle()+Math.PI));
		
		((GeneralPath)shape).lineTo(r.getXCenter()+r.getRadius()*Math.cos(r.getAngle2()+Math.PI),r.getYCenter()-r.getRadius()*Math.sin(r.getAngle2()+Math.PI));
		
		((GeneralPath)shape).closePath();
		
		scaledShape=new GeneralPath();
		
		((GeneralPath)scaledShape).moveTo(r.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(r.getAngle()),r.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(r.getAngle()));
		
		((GeneralPath)scaledShape).lineTo(r.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(r.getAngle2()),r.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(r.getAngle2()));
		
		((GeneralPath)scaledShape).lineTo(r.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(r.getAngle()+Math.PI),r.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(r.getAngle()+Math.PI));
		
		((GeneralPath)scaledShape).lineTo(r.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(r.getAngle2()+Math.PI),r.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-r.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(r.getAngle2()+Math.PI));
		
		((GeneralPath)scaledShape).closePath();
	}
}
