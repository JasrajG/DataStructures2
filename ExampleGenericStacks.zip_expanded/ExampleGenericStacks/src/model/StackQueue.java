package model;


//---------This is my own code-----------
public class StackQueue<E> implements Queue<E>{
	private Stack<E> inStack;
	private Stack<E> outStack;
	
	public StackQueue(){
		inStack = new LinkedStack<E>();
		outStack = new LinkedStack<E>();
	}
	public E first() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("the queue is empty!");
		}
		else {
			if (!outStack.isEmpty()) {
				return outStack.pop();
			}
			else {
				while (!inStack.isEmpty()) {
					outStack.push(inStack.pop());
				}
				return outStack.pop();
			}
		}
	}
	
	
	public int size() {
		return (inStack.size()+outStack.size());
		
	}
	
	public boolean isEmpty() {
		
		return (inStack.isEmpty() && outStack.isEmpty());
	}
	
	public void enqueue(E e) {
		inStack.push(e);
	}
	
	public E dequeue() {
		if (this.size() == 0) {
			throw new IllegalArgumentException("the queue is empty!");
		}
		if (!outStack.isEmpty()) {
			return outStack.pop();
		}
		else {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			return outStack.pop();
		}
	}
	

	
}

