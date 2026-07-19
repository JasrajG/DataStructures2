package model;

import tests.*;

public class TreeUtilities<E> {

	public TreeNode<E> copyOf(TreeNode<E> n){
		
		//create copy of root
		TreeNode<E> root = new TreeNode<E>(n.getElement());
		
		SLLNode<TreeNode<E>> current = n.getChildren();
		while(current!=null) {
			
			TreeNode<E> duplicate = copyOf(current.getElement());
			root.addChild(duplicate);
			duplicate.setParent(root);
			
			current=current.getNext();
		}
		
		return root;
	}

	public SLLNode<TreeNode<E>> getPreOrderSeq(TreeNode<E> n1) {
		
		SLLNode<TreeNode<E>> head = new SLLNode<TreeNode<E>>(n1, null);
		SLLNode<TreeNode<E>> tail = head;
		SLLNode<TreeNode<E>> current = n1.getChildren();
		
		while(current!=null) {
			tail.setNext(getPreOrderSeq(current.getElement()));
			//go to the very end
			while(tail.getNext()!=null) {
				tail=tail.getNext();
			}
			current=current.getNext();
		}
		
		return head;
	}
}
