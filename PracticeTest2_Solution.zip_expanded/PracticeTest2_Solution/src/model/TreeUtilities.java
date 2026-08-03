package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities<E> {
	
	public TreeNode<E> copyOf(TreeNode<E> input) {
		TreeNode<E> output = new TreeNode<>(input.getElement());
		
		if(input.getChildren() != null) {
			SLLNode<TreeNode<E>> children = input.getChildren();
			while(children != null) {
				TreeNode<E> child = copyOf(children.getElement());
				child.setParent(output);
				output.addChild(child);
				children = children.getNext();
			}
		}
		
		return output;
	}
	
	public SLLNode<TreeNode<E>> getPreOrderSeq(TreeNode<E> root) {
		SLLNode<TreeNode<E>> result = new SLLNode<>(root, null);
		
		if(root.getChildren() != null) {
			SLLNode<TreeNode<E>> children = root.getChildren();
			while(children != null) {
				TreeNode<E> child = children.getElement();
				addLast(result, getPreOrderSeq(child));
				children = children.getNext();
			}
		}
		
		return result;
	}
	
	private void addLast(SLLNode<TreeNode<E>> head, SLLNode<TreeNode<E>> e) {
		SLLNode<TreeNode<E>> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(e);
	}
}