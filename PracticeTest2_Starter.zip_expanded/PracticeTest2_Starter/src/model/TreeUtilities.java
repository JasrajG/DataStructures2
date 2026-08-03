package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities<E> {

	public TreeNode<E> copyOf(TreeNode<E> n) {
		
		//create a copy root node (base)
		TreeNode<E> n_copy = new TreeNode<E>(n.getElement());
		
		//recursive step
		SLLNode<TreeNode<E>> current = n.getChildren();
		while (current!=null) {
			TreeNode<E> child_subtree = copyOf(current.getElement());
			n_copy.addChild(child_subtree);
			child_subtree.setParent(n_copy);
					
			current = current.getNext();
		}
		
		
		return n_copy;
	}
	
	
	
	

	public SLLNode<TreeNode<E>> getPreOrderSeq(TreeNode<E> n1) {
		// TODO Auto-generated method stub
		
		SLLNode<TreeNode<E>> head = new SLLNode<TreeNode<E>> (n1, null);
		SLLNode<TreeNode<E>> tail = head;
		
		
		SLLNode<TreeNode<E>> current  = n1.getChildren();
		
		while (current != null) {
			
			tail.setNext(getPreOrderSeq(current.getElement()));
			while(tail.getNext() != null) {
				tail = tail.getNext();
			}
			
			current = current.getNext();
		}
		
		
		return head;
	}

}
