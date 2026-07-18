package model;

public class TreeUtilities<E> {
	
	/*
	 * Return the depth of node `n`.
	 */
	public int depth(TreeNode<E> n) {
		if(n.getParent() == null) { 
			/* depth of root is 0 */
			return 0;
		}
		else {
			return 1 + depth(n.getParent());
		}
	}
	
	/*
	 * Return the height of the subtree rooted at node `n`.
	 */
	public int height(TreeNode<E> n) {
		TreeNode<E>[] children = n.getChildren();
		if(children.length == 0) {
			/* height of the subtree rooted at an external node is 0 */
			return 0;
		}
		else {
			int max = 0;
			for(int i = 0; i < children.length; i ++) {
				int h = 1 + height(children[i]);
				max = h > max ? h : max;
			}
			return max;
		}
	}
	
	/*
	 * Return all ancestors of node `n` as an array.
	 */
	public TreeNode<E>[] ancestors(TreeNode<E> n) {
		/*
		 * Exercise
		 */
		return null;
	} 
	
	/*
	 * Return all descendants of node `n` as an array.
	 */
	public TreeNode<E>[] descendants(TreeNode<E> n) {
		/*
		 * Exercise
		 */
		return null;
	} 
}
