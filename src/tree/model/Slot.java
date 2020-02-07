package tree.model;

import java.io.Serializable;

import element.IElement;
import element.PictureElement;
import element.TextElement;
import tree.model.geometry.IGeometry;

public class Slot implements Serializable{
	
	public enum ElementType{
		TEXT,
		PICTURE
	}
	private IGeometry g;
	private IElement element;
	public Slot(IGeometry g) {
		this.g=g;
	}
	
	public IGeometry getGeometry() {
		return g;
	}
	
	public void setGeometry(IGeometry g) {
		this.g=g;
	}
	
	public void createElement(ElementType E) {
		if(E == ElementType.TEXT) {
			element = (IElement) new TextElement();
		}
		else if(E == ElementType.PICTURE) {
			element = (IElement) new PictureElement();
		}
	}
	
	public IElement getElement() {
		return element;
	}
	public void refreshPainter() {
		this.g.refreshPainter();
	}
}
