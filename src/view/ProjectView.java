package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.listeners.change.DocumentViewsSelectionListener;
import observer.interfaces.IOListener;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;

public class ProjectView extends JPanel implements IOListener {
	
	private Project p;
	
	private String name;
	
	private JLabel label;
	
	private String defaultMessage = "Select a project";
	
	private JTabbedPane documentViews;
	
	private DocumentViewsSelectionListener dVSelectionListener;
	
	
	public ProjectView() {
		setLayout(new BorderLayout());
		name = defaultMessage;
		label = new JLabel(name);
		documentViews = new JTabbedPane(JTabbedPane.TOP);
		this.add(label,BorderLayout.NORTH);
		this.add(documentViews,BorderLayout.CENTER);
		p = null;
		dVSelectionListener = new DocumentViewsSelectionListener();
	}
	
	@Override
	public void update(Object o) {
		if(o instanceof Project) {
			Project p = (Project)(o);
			if(p.getErased() || !p.isSelected()) {
				clear();
			}
			else {
				clear();
				set(p);
			}
		}
	}
	
	public void clear() {
		//documentViews.removeChangeListener(dVSelectionListener);
		int n = documentViews.getComponentCount();
		ArrayList<DocumentView> tempList = new ArrayList<DocumentView>();
		for(int i=0;i<n;i++) {
			Component c = documentViews.getComponent(i);
			if(c instanceof DocumentView) {
				DocumentView dV = (DocumentView)(c);
				tempList.add(dV);
			}
		}
		for(DocumentView dV:tempList) dV.clear();
		if(this.p!=null) {
			this.p.removeObserver(this);
			this.p = null;
		}
		this.remove(documentViews);
		documentViews = new JTabbedPane(JTabbedPane.TOP);
		this.add(documentViews,BorderLayout.CENTER);
		name = defaultMessage;
		label.setText(name);
	}
	
	public void set(Project p) {
		if(p!=null && p.isSelected()) {
			this.p=p;
			//documentViews.removeChangeListener(dVSelectionListener);
			p.addObserver(this);
			name = p.toString();
			label.setText(name);
			int n=p.getChildCount();
			int t=0;
			for(int i=0;i<n;i++) {
				Document d = (Document)(p.getChildAt(i));
				if(!d.getErased() && !d.isClosed()) {
					DocumentView dV = new DocumentView(this);
					dV.set(d);
				}
			}
			n=documentViews.getComponentCount();
			for(int i=0;i<n;i++) {
				DocumentView dV = ((DocumentView)documentViews.getComponentAt(i));
				if(dV.getDocument().isSelected()) {
					documentViews.setSelectedIndex(i);
				}
			}
			//documentViews.addChangeListener(dVSelectionListener);
		}
	}
	
	public void removeFromParrent(DocumentView dV) {
		//documentViews.removeChangeListener(dVSelectionListener);
		int n=documentViews.getComponentCount();
		documentViews.remove(dV);
		//documentViews.addChangeListener(dVSelectionListener);
	}
	
	public void addToParrent(DocumentView dV) {
		//documentViews.removeChangeListener(dVSelectionListener);
		documentViews.add(dV);
		//documentViews.addChangeListener(dVSelectionListener);
	}
	
	public String getName() {
		return name;
	}
	
	public void selectDocument(Document doc) {
		int n=documentViews.getComponentCount();
		for(int i=0;i<n;i++) {
			if(((DocumentView)documentViews.getComponentAt(i)).getDocument() == doc) {
				documentViews.setSelectedIndex(i);
			}
		}
	}
	
	public void resetTitle(DocumentView dV) {
		int id=0;
		for(Component c:documentViews.getComponents()) {
			DocumentView cur = (DocumentView)(c);
			if(cur==dV) break;
			id++;
		}
		if(id>=documentViews.getComponentCount()) return;
		documentViews.setTitleAt(id, dV.getName());
	}
	
	public JTabbedPane getDocumentViews() {
		return documentViews;
	}
	
	public Project getProject() {
		return p;
	}
	
	public Page getOpenedPage() {
		DocumentView d = (DocumentView)documentViews.getSelectedComponent();
		if(d==null || d.getPageView()==null)
			return null;
		
		return d.getPageView().getPage();
	}
	
	public void refresh() {
		label.setText(name);
		if(documentViews.getSelectedComponent()==null) return;
		DocumentView dV = (DocumentView)documentViews.getSelectedComponent();
		dV.refresh();
		documentViews.setSelectedComponent(dV);
	}
}
