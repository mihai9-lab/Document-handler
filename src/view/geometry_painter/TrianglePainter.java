package view.geometry_painter;

import java.awt.geom.GeneralPath;

import tree.model.geometry.TriangleGeometry;

public class TrianglePainter extends GeometryPainter{
	public TrianglePainter(TriangleGeometry t) {
		super(t);
		
		shape=new GeneralPath();
		
		((GeneralPath)shape).moveTo(t.getXCenter()+t.getRadius()*Math.cos(t.getAngle()),t.getYCenter()-t.getRadius()*Math.sin(t.getAngle()));
		
		((GeneralPath)shape).lineTo(t.getXCenter()+t.getRadius()*Math.cos(t.getAngle()+Math.PI*2/3),t.getYCenter()-t.getRadius()*Math.sin(t.getAngle()+Math.PI*2/3));
		
		((GeneralPath)shape).lineTo(t.getXCenter()+t.getRadius()*Math.cos(t.getAngle()-Math.PI*2/3),t.getYCenter()-t.getRadius()*Math.sin(t.getAngle()-Math.PI*2/3));
		
		
		((GeneralPath)shape).closePath();
		
		
		scaledShape=new GeneralPath();
		
		((GeneralPath)scaledShape).moveTo(t.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+t.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(t.getAngle()),t.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-t.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(t.getAngle()));
		
		((GeneralPath)scaledShape).lineTo(t.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+t.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(t.getAngle()+Math.PI*2/3),t.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-t.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(t.getAngle()+Math.PI*2/3));
		
		((GeneralPath)scaledShape).lineTo(t.getXCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()+t.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.cos(t.getAngle()-Math.PI*2/3),t.getYCenter()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()-t.getRadius()*gui.Frame.getInstance().getIConfigurations().getMinipageScalingCoef()*Math.sin(t.getAngle()-Math.PI*2/3));
		
		
		((GeneralPath)scaledShape).closePath();
	}
}
