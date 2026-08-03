package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> n, int i, int j) {
		
		
		
		
		//start by creating header node which lets us not need special cases
		SLLNode<Integer> header = new SLLNode<Integer>(null,null);
		
		
		
		
		helper(n, header);
		
		//now we have an organized list, we need to modify it so that it has the specified indicees
		
		//start with j
		SLLNode<Integer> current = header;
		for (int c = 0; c < j; c++) {
			current = current.getNext();
		}
		
		current.setNext(null);
		
		//now i
		current = header;
		for (int c = 0; c < i; c++) {
			current = current.getNext();
		}
		
		return current;
	}
	
	private void helper(TreeNode<Integer> n, SLLNode<Integer> header){
		
		//add n first
		int n_int = n.getElement();
		
		SLLNode<Integer> current = header;
		while(current.getNext() != null && current.getNext().getElement() < n_int) {
			current = current.getNext();
		}
		current.setNext(new SLLNode<Integer>(n_int, current.getNext()) );
		
		//call it on the children now
		
		SLLNode<TreeNode<Integer>> children  = n.getChildren();
		
		while (children !=null) {
			helper(children.getElement(), header);
			children = children.getNext();
		}
		
		
	}

	public TreeNode<String> getStats(TreeNode<Integer> n) {
		//start with just recreating the structure
		TreeNode<String> n_copy = helper1(n);
		
		//now we add number of descendatns
		helper2(n, n_copy);
		
		//finally the sum of descenedants
		helper3(n, n_copy);
		
		return n_copy;
	}
	
	private TreeNode<String> helper1(TreeNode<Integer> n) {
		TreeNode<String> n_copy = new TreeNode<String>("");
		SLLNode<TreeNode<Integer>> children = n.getChildren();
		while (children!= null) {
			TreeNode<String> child_copy = helper1(children.getElement());
			n_copy.addChild(child_copy);
			child_copy.setParent(n_copy);
			children = children.getNext();
		}
		return n_copy;
	}
	
	private int helper2(TreeNode<Integer> n, TreeNode<String> n_copy) {
		
		
		int i = 1;
		SLLNode<TreeNode<Integer>> children = n.getChildren();
		SLLNode<TreeNode<String>> children2 = n_copy.getChildren();
		while (children!= null) {
			i += helper2(children.getElement(), children2.getElement());
			
			children = children.getNext();
			children2 = children2.getNext();
		}
		
		//write i into the node itself
		
		n_copy.setElement(String.format("Number of descendants: %d;", i));
		return i;
	}
	
	
	private int helper3(TreeNode<Integer> n, TreeNode<String> n_copy) {
		
		
		int i = n.getElement();
		SLLNode<TreeNode<Integer>> children = n.getChildren();
		SLLNode<TreeNode<String>> children2 = n_copy.getChildren();
		while (children!= null) {
			i += helper3(children.getElement(), children2.getElement());
			
			children = children.getNext();
			children2 = children2.getNext();
		}
		
		//write i into the node itself
		
		n_copy.setElement(n_copy.getElement() +String.format(" Sum of descendants: %d", i));
		return i;
	}
	
	
	
	
	
	
}
