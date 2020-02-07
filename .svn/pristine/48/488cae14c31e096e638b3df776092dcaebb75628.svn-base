package tree.model;

import java.io.Serializable;
import java.util.TreeSet;

public class NewNodeNumberSet implements Serializable,Cloneable{

	private TreeSet<Integer> nodeNumbers;
	private int maxNodes;
	private int increaseBy;
	
	public NewNodeNumberSet() {
		maxNodes=0;
		increaseBy=10;
		nodeNumbers= new TreeSet<Integer>();
		this.addNumbersToSet();
		
	}
	
	private void addNumbersToSet() {
		
		for(int i = this.maxNodes+1; i <= this.maxNodes+increaseBy; i++)
			this.nodeNumbers.add(i);
		this.maxNodes+=increaseBy;
	}
	
	public int getNumber() {
		int number= this.nodeNumbers.pollFirst();
		if(this.nodeNumbers.isEmpty())
			this.addNumbersToSet();
		
		return number;
	}
	
	public void giveBackNumber(int number) {
		this.nodeNumbers.add(number);
	}
}
