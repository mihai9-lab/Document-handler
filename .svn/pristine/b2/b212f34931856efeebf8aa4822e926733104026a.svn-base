package element;

import javax.swing.text.DefaultStyledDocument;

import element.viewer.TextEditor;

public class TextElement implements IElement{

	private DefaultStyledDocument document;
	
	public TextElement() {
		document= new DefaultStyledDocument();
	}
	@Override
	public void edit() {
		document= TextEditor.showGUI(document);
	}

}
