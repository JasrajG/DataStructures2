package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.TreeUtilities;

public class TestDemo extends TestBase {
	TreeUtilities u;
	
	@Before 
	public void setup() {
		u = new TreeUtilities();
	}
	
	
	@Test
	public void test_demo() {
		List<Expression> tokens = tokenize("23 46 +"); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		TreeNode<Integer> expectedShape = t(2,
				t(0),
				t(1)
		);
		
		checkTrees(expectedShape, tokens, root);
		
		assertEquals("(23 + 46)", u.getInfixSequence(expression));
	}
	
	public String formatTree(TreeNode<Expression> root, int level, List<Expression> tokens, boolean hasSibling) {
		SLLNode<TreeNode<Expression>> children = root.getChildren();

		String value = "";
		if (root.getElement() instanceof Operator) {
			value = ((Operator)root.getElement()).getOperator()+"";
		} else {
			value = ((Operand)root.getElement()).getValue() + "";
		}
		int idx = tokens.indexOf(root.getElement());
		
		if (children == null) {
			if(hasSibling) {
				return String.format("t(%s), // %s", 
					idx, value);
			} else {
				return String.format("t(%s) // %s", 
						idx, value);
			}
		} else {
			List<String> res = new ArrayList<>();
			while (children != null) {
				res.add(formatTree(children.getElement(), level+1, tokens, children.getNext() != null));
				children = children.getNext();
			}
			return String.format("t(%s, // %s\n %s\n)\n", idx, value, String.join("\n", res));
		}
	}
	
	@Test
	public void get_tree_shape() {
//		String postStr = "1 2 * 31 40 + - 55 +";
//		String postStr = "1 2 * 31 40 + 55 + 9 * -";
//		String postStr = "1 2 31 40 + 55 + - 2 * 3 - * 9 *";
//		String postStr = "1 3 69 + 8 * -";
//		String postStr = "3 1 + 3 * 9 5 - 2 + * 3 7 4 - * 6 + - 8 * 2 1 - 2 3 9 - * + +";
		String postStr = "0 -3 + 1 -";
		List<Expression> tokens = tokenize(postStr); 
		
		List<SLLNode<Expression>> expressions = createNodes(tokens);
		
		SLLNode<Expression> expression = expressions.get(0);
		
		TreeNode<Expression> root = u.getInfixTree(expression);
		
		String result = formatTree(root, 1, tokens, false);
		System.out.print(result);
	}
	
}
