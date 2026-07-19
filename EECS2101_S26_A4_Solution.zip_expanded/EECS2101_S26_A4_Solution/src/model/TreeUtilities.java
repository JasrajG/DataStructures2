package model;

import tests.TreeNode;
import tests.Expression;
import tests.Operand;
import tests.Operator;
import tests.SLLNode;

public class TreeUtilities {
	public TreeNode<Expression> getInfixTree(SLLNode<Expression> input){
		
		//head is the top of our stack
		SLLNode<TreeNode<Expression>> head = null;
		SLLNode<Expression> current = input;
		
		while (current != null) {
			
			TreeNode<Expression> currentDup = new TreeNode<Expression>(current.getElement());
			//push
			if (current.getElement() instanceof Operand) {
				head = new SLLNode<TreeNode<Expression>>(currentDup,head);
			}
			
			
			//pop
			else {
				
				
				currentDup.addChild(head.getNext().getElement());
				head.getNext().getElement().setParent(currentDup);
				
				
				
				currentDup.addChild(head.getElement());
				head.getElement().setParent(currentDup);
				head=head.getNext().getNext();
				
				
				head = new SLLNode<TreeNode<Expression>>(currentDup,head);
			}
			
			
			current=current.getNext();
		}
		
		
		return head.getElement();
		
	}
	
	
	
	
	
	
	public String getInfixSequence(SLLNode<Expression> input){
		
	//head is the top of our stack
			SLLNode<String> head = null;
			SLLNode<Expression> current = input;
			
			while (current != null) {
				
				//push
				if (current.getElement() instanceof Operand) {
					head = new SLLNode<String>(String.format("%d", ((Operand)current.getElement()).getValue()),head);
				}
				
				
				//pop
				else {
					
					
					String s = '(' + head.getNext().getElement() + ' ' + ((Operator)current.getElement()).getOperator() + ' ' + head.getElement() + ')';
					
					
					
					head=head.getNext().getNext();
					
					
					head = new SLLNode<String>(s,head);
				}
				
				
				current=current.getNext();
			}
			
			
			return head.getElement();
				
		

	}
}