package tree.model;

import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import observer.interfaces.IOListener;
import observer.interfaces.IObserver;
import sharing.mediator.MediatorUpdates;
import view.DocumentView;

public class Page implements TreeNode,IObserver,Serializable,Transferable{

	transient private ArrayList<IOListener> listeners;
	transient private PageSelectedSlots pageSelectedSlots;

	static public DataFlavor pageFlavor;
	static private DataFlavor[] supportedFlavors = {pageFlavor};
	
	private String name;
	private Document parentNode;
	private int newPageNumber;
	transient private boolean erased;
	transient private boolean selected;
	private boolean changed=true;
	
	private ArrayList<Slot> slots;

	public Page(Document parentNode, String name, int number) {
		this.erased = false;
		this.selected = false;
		this.parentNode = parentNode;
		this.name = name;
		this.newPageNumber = number;
		pageSelectedSlots = new PageSelectedSlots(this);
		slots = new ArrayList<Slot>();
		
		try {
			pageFlavor = new DataFlavor(Class.forName("tree.model.Page"),"Page");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void removePage() {
		erased=true;
		parentNode.removePage(this);
		registerChange();
	}
	public void renameNewPage(String name) {
		this.name=name;
		registerChange();
		notifyObserver(this);
	}
	public void renamePage(String name) {
		this.name=name;
		if(newPageNumber!=0) {
			parentNode.returnNumber(newPageNumber);
			newPageNumber = 0;
		}
		registerChange();
		this.parentNode.updateMediator(MediatorUpdates.PAGE_NAME, this);
		notifyObserver(this);
	}
	
	protected void setNumber(int number) {
		newPageNumber = number;
	}
	
	protected void setParentNode(Document doc) {
		this.parentNode =  doc;
	}
	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public TreeNode getParent() {
		return parentNode;
	}

	@Override
	public int getIndex(TreeNode node) {
		return -1;
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}
	public boolean getErased() {
		return erased;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return null;
	}

	@Override
	public void addObserver(IOListener listener) {

		if(listener == null)
			return;
		if(listeners == null)
			listeners = new ArrayList<IOListener>();
		if(listeners.contains(listener))
			return;
		listeners.add(listener);

	}

	@Override
	public void removeObserver(IOListener listener) {

		if(listener == null)
			return;
		if(!listeners.contains(listener))
			return;
		listeners.remove(listener);

	}

	@Override
	public void notifyObserver(Object event) {

		if(event == null)
			return;
		registerChange();
		if(listeners == null)
			return;

		ArrayList<IOListener> temporaryListeners = new ArrayList<IOListener>();
		for(IOListener listener:listeners) temporaryListeners.add(listener);
		for(IOListener listener:temporaryListeners) {
			listener.update(event);
		}
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	public void registerChange() {
		this.changed=true;
		parentNode.registerChange();
	}
	
	public void setChanged(boolean changed) {
		this.changed=changed;
	}
	
	public void setSelected(boolean selected) {
		if(!selected) this.pageSelectedSlots.clearSelection();
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	private Object readResolve(){
		listeners = new ArrayList<IOListener>();
		pageSelectedSlots = new PageSelectedSlots(this);
		erased = false;
		selected = false;
		try {
			pageFlavor = new DataFlavor(Class.forName("tree.model.Page"),"Page");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 return this;
	}


	public int getNewPageNumber() {
		return newPageNumber;
	}
	
	public int getSlotsCount() {
		return slots.size();
	}
	
	public Slot getSlot(int i) {
		return slots.get(i);
	}
	public ArrayList<Slot> getSlots() {
		return slots;
	}
	public void setSlots(ArrayList<Slot> slots) {
		this.slots=slots;
	}
	public void addSlot(Slot s) {
		slots.add(s);
		//((Document)parentNode).updateMediator(MediatorUpdates.PAGE_NEW_SLOT, s);
		notifyObserver(this);
	}
	
	public void removeSlot(Slot s) {
		//((Document)parentNode).updateMediator(MediatorUpdates.PAGE_REMOVE_SLOT, s);
		slots.remove(s);
		notifyObserver(this);
	}
	
	public void removeSlot(int i) {
		//((Document)parentNode).updateMediator(MediatorUpdates.PAGE_REMOVE_SLOT, slots.get(i));
		slots.remove(i);
		notifyObserver(this);
	}
	
	public PageSelectedSlots getPageSelectedSlots() {
		return pageSelectedSlots;
	}


	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}


	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		if(flavor.equals(pageFlavor)) 
			return true;
		return false;
	}


	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(flavor.equals(pageFlavor))
			return this;
		else
			throw new UnsupportedFlavorException(pageFlavor);
	}
	
	public Slot contains(Point p) {
		for(Slot s: slots) 
			if(s.getGeometry().getGeometryPainter().elementAt(p)) 
				return s;
				
		return null;
	}
	public void refreshPainters() {
		for(Slot s:slots) {
			s.refreshPainter();
		}
	}
	
	public void select() {
		this.selected = true;
		if(!this.parentNode.isSelected()) this.parentNode.select();
		this.parentNode.updateSelected(this);
	}
}
