package model;

import tests.TreeNode;
import tests.SLLNode;

public class TreeUtilities {

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> n, int i, int j) {
		
		
		
		//initialize SLL
		SLLNode<Integer> header = new SLLNode<Integer>(null,null);
		
		getElementsOfRanksH(n, header);
		
		//get rid of extra nodes at the end
		SLLNode<Integer> current = header;
		for (int h = 0; h <j;h++ ) {
		current=current.getNext();
		}
		current.setNext(null);
		
		//go to the specified beginning
		current = header;
		for (int h = 0; h<i;h++ ) {
			current=current.getNext();
			}
		
		
		return current;
	}
	
	private SLLNode<Integer> getElementsOfRanksH(TreeNode<Integer> n, SLLNode<Integer> header){
		
		//add parent node first
		add(n,header);
		//go through children and recrusively call this method
		SLLNode<TreeNode<Integer>> child = n.getChildren();
		while (child != null) {
			//next line needs to be change
			getElementsOfRanksH(child.getElement(), header);
			child=child.getNext();
		}
		
		
		return null;
	}
	
	private void add(TreeNode<Integer> n, SLLNode<Integer> header) {
		
	
		
	
			
		//loop through until you either hit a larger int, or the end of the list
		int num = n.getElement();
		SLLNode<Integer> current=header;
		while(current.getNext() != null && current.getNext().getElement()<num) {
			current=current.getNext();
		}
		current.setNext(new SLLNode<Integer>(num,current.getNext()));

	}
	
	
	
	
	
	
	public TreeNode<String> getStats(TreeNode<Integer> n){
		
		//helper 1 recreates the tree structure in String form
		TreeNode<String> root = helper1(n);
		
		//helper 2
		helper2(n,root);
		
		//helper 3
		helper3(n,root);
		
		return root;
	}
	
	//create tree structure first
	private TreeNode<String> helper1(TreeNode<Integer> n) {
		TreeNode<String> root = new TreeNode<String>("");
		SLLNode<TreeNode<Integer>> child = n.getChildren();
		while (child != null) {
			TreeNode<String> newChild = helper1(child.getElement());
			root.addChild(newChild);
			newChild.setParent(root);
			
			
			
			child=child.getNext();
		}
		
		return root;
	}
	
	//number of descendants
	private int helper2(TreeNode<Integer> n, TreeNode<String> n2){
		SLLNode<TreeNode<Integer>> child = n.getChildren();
		SLLNode<TreeNode<String>> child2 = n2.getChildren();
		int j = 1;
		while (child != null) {
			j+= helper2(child.getElement(), child2.getElement());
			
			
			child=child.getNext();
			child2=child2.getNext();
		}
		n2.setElement(String.format("Number of descendants: %d;",j));
		return j;
	}
	
	private int helper3(TreeNode<Integer> n, TreeNode<String> n2){
		SLLNode<TreeNode<Integer>> child = n.getChildren();
		SLLNode<TreeNode<String>> child2 = n2.getChildren();
		int j = n.getElement();
		while (child != null) {
			j+= helper3(child.getElement(), child2.getElement());
			
			
			child=child.getNext();
			child2=child2.getNext();
		}
		n2.setElement(n2.getElement()+String.format(" Sum of descendants: %d",j));
		return j;
	}
	

}
