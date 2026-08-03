package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestBase {

    @SafeVarargs
    @SuppressWarnings("varargs")
	public final <T> TreeNode<T> t(T root, TreeNode<T>... children) {
		TreeNode<T> rootNode = new TreeNode<>(root);
		for (TreeNode<T> child: children) {
			rootNode.addChild(child);
			child.setParent(rootNode);
		}
		return rootNode;
	}
    

	<T> void checkValuesInOrder(List<T> values, SLLNode<T> actualHead) {
		SLLNode<T> actualNode = actualHead;
		for (T v: values) {
			// check refer
			assertNotNull(actualNode);
			assertEquals(v, actualNode.getElement());
			actualNode = actualNode.getNext();
		}
		assertNull(actualNode);
	}

	void checkOutputForAllLevels(TreeNode<String> output, List<List<String>> expectedList) {
		/* each element in the expectedList is a list, describing the expected output in order 
		 * (top to bottom, left to right).
		 * e.g., if the tree is:
		 * t(46,
		 * 	t(23,
		 * 		t(92), t(69)
		 * 	), t(115,
		 * 		t(138)
		 * 	), t(161)
		 * )
		 * then the expected list should be:
		 * [
		 * 	[#46],
		 * 	[#23, #115, #161],
		 * 	[#92, #69],
		 * 	[#138]
		 * ]
		 */
		// since we need at least one root is present in the tree.
		assert expectedList.size() > 0 && expectedList.get(0).size() == 1; 
		
		// check the root
		assertNull(output.getParent());
		assertEquals(expectedList.get(0).get(0), output.getElement());

		List<SLLNode<TreeNode<String>>> nextSSLNodes = new ArrayList<>();
		List<TreeNode<String>> parentNodeQueue = new ArrayList<>();
		
		// add all children
		nextSSLNodes.add(output.getChildren());
		parentNodeQueue.add(output);
		
		for (int i =1 ; i < expectedList.size(); i++) {
			List<String> expected = expectedList.get(i);
			TreeNode<String> parentNode = parentNodeQueue.remove(0);
			SLLNode<TreeNode<String>> currentSSLNode = nextSSLNodes.remove(0);
			
			if (expected == null) {
				assertNull(currentSSLNode);
				continue;
			}
			
			for (String v: expected) {
				// additional assertion
				assertNotNull(currentSSLNode);
				
				TreeNode<String> currentTreeNode = currentSSLNode.getElement();
				// add to the explore queue.
				nextSSLNodes.add(currentTreeNode.getChildren());
				parentNodeQueue.add(currentTreeNode);
				
				// check parent
				assertTrue(currentTreeNode.getParent() == parentNode);
				// check value.
				assertEquals(v, currentTreeNode.getElement());
				
				// move to next.
				currentSSLNode = currentSSLNode.getNext();
			}
			// should reach to end.
			assertNull(currentSSLNode);
		}
	}
	
	String statMsg(int num, int sum) {
		return String.format("Number of descendants: %d; Sum of descendants: %d", num, sum);
	}
    
}
