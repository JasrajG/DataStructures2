package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	<T> List<SLLNode<T>> createNodes(List<T> list){
		SLLNode<T> node = null;
		List<SLLNode<T>> createdNodes = new ArrayList<>();
		for (int i =list.size()-1; i >=0; i--) {
			node = new SLLNode<>(list.get(i), node);
			createdNodes.add(0, node); // add to first.
		}
		return createdNodes;
	}
	
    public final Expression e(int a) {
    	return new Operand(a);
    }
    
    public final Expression e(char a) {
    	return new Operator(a);
    }

	List<Expression> tokenize(String postfixStr){
		List<String> operations = Arrays.asList("+", "-", "*", "/");
		
		List<Expression> tokens = new ArrayList<>();
		for (String str: postfixStr.split(" ")) {
			if (operations.contains(str)) {
				tokens.add(e(str.charAt(0)));
			} else {
				tokens.add(e(Integer.valueOf(str)));
			}
		}
		return tokens;
	}
    

    <T> List<TreeNode<T>> getNodesInOrder(SLLNode<TreeNode<T>> head) {
    	List<TreeNode<T>> result = new ArrayList<>();
    	while(head != null) {
    		result.add(head.getElement());
    		head = head.getNext();
    	}
    	return result;
    }

	<T> void checkTreeNodesInOrder(List<T> values, SLLNode<TreeNode<T>> actualHead, TreeNode<T> parent) {
		SLLNode<TreeNode<T>> actualNode = actualHead;
		for (T v: values) {
			assertNotNull(actualNode);
			assertTrue(actualNode.getElement().getParent() == parent);
			assertEquals(v, actualNode.getElement().getElement());
			// not the same object.
			assertTrue(v == actualNode.getElement().getElement());
			actualNode = actualNode.getNext();
		}
		assertNull(actualNode);
	}
	
	void checkTrees(TreeNode<Integer> expected, List<Expression> tokens, TreeNode<Expression> actual) {
		assertTrue(tokens.get(expected.getElement()) == actual.getElement());
		
		SLLNode<TreeNode<Integer>> originHead = expected.getChildren();
		SLLNode<TreeNode<Expression>> mirrorHead = actual.getChildren();
		
		List<TreeNode<Integer>> expectedIdxs = getNodesInOrder(originHead);
		
		List<Expression> expressionList = expectedIdxs.stream()
				.map(i -> tokens.get(i.getElement())).collect(Collectors.toList());
		
		if (expressionList.size() == 0) {
			// assertNull.
			assertNull(mirrorHead);
		} else {
			checkTreeNodesInOrder(expressionList, mirrorHead, actual);
		}
		
		// check it recursively.
		SLLNode<TreeNode<Expression>> currentHead = mirrorHead;
		for (TreeNode<Integer> v : expectedIdxs) {
			checkTrees(v, tokens, currentHead.getElement());
			currentHead = currentHead.getNext();
		}
		assertNull(currentHead);
	}
	
}
