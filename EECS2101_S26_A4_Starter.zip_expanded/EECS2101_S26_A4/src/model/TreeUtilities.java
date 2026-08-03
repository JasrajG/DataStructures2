package model;

import tests.Expression;
import tests.Operand;
import tests.Operator;
import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	public TreeNode<Expression> getInfixTree(SLLNode<Expression> expression) {
		
		SLLNode<TreeNode<Expression>> stack = null;
		while (expression != null) {
			
			//create TreeNode
			TreeNode<Expression> current = new TreeNode<Expression>(expression.getElement());
			
			//push
			if(expression.getElement() instanceof Operand) {
				stack = new SLLNode<TreeNode<Expression>>(current, stack);
			}
			
			else {
			
			current.addChild(stack.getNext().getElement());
			current.addChild(stack.getElement());
			
			stack.getNext().getElement().setParent(current);
			stack.getElement().setParent(current);
			
			//pop 2, push 1
			
			stack = new SLLNode<TreeNode<Expression>>(current, stack.getNext().getNext());
				
			}
			
			
			
			
			expression = expression.getNext();
		}
		
		return stack.getElement();
	}

	public Object getInfixSequence(SLLNode<Expression> expression) {
		SLLNode<String> stack = null;
		while (expression != null) {
			
			//create TreeNode
			
			//push
			if(expression.getElement() instanceof Operand) {
				stack = new SLLNode<String>(String.format("%d", ((Operand)expression.getElement()).getValue()), stack);
			}
			
			else {
				String h = '(' + stack.getNext().getElement() + String.format(" %c ", ((Operator)expression.getElement()).getOperator()) + stack.getElement() + ')';
		
			
			//pop 2, push 1
			
			stack = new SLLNode<String>(h, stack.getNext().getNext());
				
			}
			
			
			
			
			expression = expression.getNext();
		}
		
		return stack.getElement();
	}

}
