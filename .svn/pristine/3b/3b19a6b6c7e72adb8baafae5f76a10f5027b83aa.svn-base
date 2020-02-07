package sharing.mediator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import tree.model.Document;
import tree.model.Page;
import tree.model.Project;
import tree.model.Slot;

public class Mediator {
	
	private ArrayList<Document> documents;
	private boolean inUse;
	public Mediator() {
		documents = new ArrayList<Document>();
		inUse=false;
	}
	
	public void addNew(Document doc) {
		boolean b = true;
		for(Document d: documents)
			if(doc==d)
				b=false;
		if(b)
			documents.add(doc);
		
		Project prj = new ProjectListDialog().open();
		if(prj==null)
			return;
		Document n = (Document)cloneAny(doc);
		n.setMediator(this);
		n.setShared(true);
		
		for(int i=0;i<doc.getChildCount();i++) 
			((Page)n.getChildAt(i)).setSlots(((Page)doc.getChildAt(i)).getSlots());
		
		documents.add(n);
		prj.add(n);
		
	}
	
	public void removeDocument(Document doc) {
		int counter=0;
		for(Document d: documents){
			if(d==doc)
				break;
			counter++;
		}
		documents.remove(counter);	
		if(documents.size()==1)
			documents.get(0).setShared(false);
	}
	
	public void mediate(Document doc,MediatorUpdates ACTION, Object o ) {
		if(inUse==false) {
			inUse=true;
				
				if(ACTION == MediatorUpdates.DOCUMENT_NAME)
					changeDocumentName(doc);
				else if(ACTION == MediatorUpdates.DOCUMENT_NEW_PAGE)
					addNewPage(doc,(Page)o);
				else if(ACTION == MediatorUpdates.PAGE_NAME)
					changePageName(doc,(Page)o);
				else if(ACTION == MediatorUpdates.PAGE_REMOVE)
					removePage(doc,(Page)o);
				else if(ACTION == MediatorUpdates.PAGE_COMMAND)
					command();
			inUse=false;
		}
		
	}
	
	private void changeDocumentName(Document doc) {
		String newName = doc.getName();
		
		for(Document d: documents)
			if(d != doc)
				d.renameDocument(new String(newName));
		
	}
	
	private void addNewPage(Document doc, Page pg) {
		for(Document d: documents)
			if(d != doc) {
				Page n = (Page)cloneAny(pg);
				n.setSlots(pg.getSlots());
				d.add(n);
			}
	}
	
	private void changePageName(Document doc, Page pg) {
		int index = doc.getIndex(pg);
		String newName = pg.toString();
		
		for(Document d: documents)
			if(d != doc)
				((Page)d.getChildAt(index)).renamePage(new String(newName));
	}
	
	private void removePage(Document doc, Page pg) {
		int index = doc.getIndex(pg);
		
		for(Document d: documents)
			if(d != doc)
				((Page)d.getChildAt(index)).removePage();
	}
	private void command() {
		for(Document d:documents)
			d.notifyObserver(d);
	}
	private static Object cloneAny(Object object) {
		try {
		     ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		     ObjectOutputStream outStream = new ObjectOutputStream(byteOutStream);
		     outStream.writeObject(object);
		     ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutStream.toByteArray());
		     ObjectInputStream inStream = new ObjectInputStream(byteInputStream);
		     return inStream.readObject();
		   }
		catch (Exception e) {
			 gui.Frame.getInstance().getExceptionHandler().handleException("unknown_error");
		     return null;
		   }
	}
}
