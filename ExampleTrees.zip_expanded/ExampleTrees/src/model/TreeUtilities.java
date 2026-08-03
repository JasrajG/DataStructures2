package model;

import java.lang.reflect.Array;

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
		
		if (n.getParent()==null) {
			TreeNode<E> arr[] = (TreeNode<E>[]) Array.newInstance(this.getClass(), 1);
			arr[0] = n;
			return arr;
		}
		
		else {
			TreeNode<E> prev[] = ancestors(n.getParent());
			TreeNode<E> arr[] = (TreeNode<E>[]) Array.newInstance(this.getClass(), prev.length + 1);
			arr[0] = n;
			for(int i= 1;i<arr.length;i++) {
				arr[i]=prev[i-1];
			}
			return arr;
		}
		

	} 
	
	/*
	 * Return all descendants of node `n` as an array.
	 */
	public TreeNode<E>[] descendants(TreeNode<E> n) {
		if (n.getChildren()[0]==null) {
			TreeNode<E> arr[] = (TreeNode<E>[]) Array.newInstance(this.getClass(), 1);
			arr[0] = n;
			return arr;
		}
		
		else {
			TreeNode<E> arr[] = (TreeNode<E>[]) Array.newInstance(this.getClass(), 0);
			for(int i =0;n.getChildren()[i] != null;i++ ) {
				TreeNode<E> prev[] = descendants(n.getChildren()[i]);
				int j = arr.length;
				TreeNode<E>new_arr[] = (TreeNode<E>[]) Array.newInstance(this.getClass(), arr.length + prev.length);
				for(int k= 0;k<j;k++) {
					new_arr[k]=arr[k];
				}
				for(int k= j;k<new_arr.length;k++) {
					new_arr[k]=prev[k-j];
				}
			}
			return arr;
		}
	} 
}
